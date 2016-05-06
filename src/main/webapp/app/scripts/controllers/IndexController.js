'use strict';
/**
 * @ngdoc function
 * @name MyLibraryApp.controller:IndexController
 * @description
 * # IndexController
 * Controller of the MyLibraryApp
 */
angular.module('MyLibraryApp')
    .controller('IndexController', function($scope, $http, ngDialog) {
        $scope.books = [];

        var fetchBooksList = function() {

            var postData = [
                {name:'currentPage',value:$scope.paginationConf.currentPage},
                {name:'itemsPerPages',value:$scope.paginationConf.itemsPerPages}
            ];

            $http.post('/book/bookList?currentPage=' + $scope.paginationConf.currentPage + '&itemsPerPages=' + $scope.paginationConf.itemsPerPages)
                .success(function(data){
                    $scope.books = data.dataList;
                    $scope.paginationConf.totalItems = data.totalRecord;
                });
        };

        $scope.paginationConf = {
            currentPage: 1,
            itemsPerPages : 5
        };

        //通过$watch currentPage和itemperPage 当他们一变化的时候，重新获取数据条目
        $scope.$watch('paginationConf.currentPage', fetchBooksList);

        //删除书籍
        $scope.delBook = function(bookId) {
            $http.post('/book/deleteBook/' + bookId)
                .success(function(data){
                    if (data.msg === "success") {
                        fetchBooksList();
                    }
                });
        };

        $scope.bookLendAway = false;
        //格式化借出
        $scope.formatLend = function(lend) {
            if (lend == 0) {
                return '<i class="fa fa-minus"></i> 借出';
            }


            if (lend == 1) {
                $scope.bookLendAway = true;
                return '<i class="fa fa-plus"></i> 返还';
            }

        };

        //借书和还书
        $scope.lendOrReturnBook = function(book) {
            var borrowerNames = [];
            var test = ['Alabama', 'Alaska'];

            $http.get('/user/getAllUserName')
                .success(function(data){
                    borrowerNames = data;

                    //借书
                    if (book.lend == 0) {
                        ngDialog.open({
                            template: 'app/partials/bookView/lendBook.html',
                            controller: ['$scope', function($scope) {
                                //提示信息显示
                                $scope.showMe = false;
                                //书籍不存在提示信息显示
                                $scope.bookNotExist = false;
                                //借阅者不存在提示信息
                                $scope.borrowerNotExist = false;

                                //隐藏信息
                                $scope.clearMsg = function() {
                                    //提示信息显示
                                    $scope.showMe = false;
                                    //书籍不存在提示信息显示
                                    $scope.bookNotExist = false;
                                    //借阅者不存在提示信息
                                    $scope.borrowerNotExist = false;
                                };

                                var showBook = function() {
                                    //提示信息显示
                                    $scope.showMe = true;
                                    //书籍不存在提示信息显示
                                    $scope.bookNotExist = true;
                                };

                                var showBorrower = function() {
                                    //提示信息显示
                                    $scope.showMe = true;
                                    //借阅者不存在提示信息
                                    $scope.borrowerNotExist = true;
                                };

                                // controller logic
                                $scope.bookName = book.bookName;
                                $scope.bookNumber = book.bookNumber;
                                $scope.borrowerNames = borrowerNames;

                                //提交借阅信息
                                $scope.submitLendBookForm = function(valid, lendBookBorrower) {
                                    var postBook = [
                                        {name:'lendBookName', value:$scope.bookName},
                                        {name:'lendBookNumber', value:$scope.bookNumber},
                                        {name:'lendBookBorrower', value:lendBookBorrower}
                                    ];
                                    var postBook1 = {
                                        lendBookName:$scope.bookName,
                                        lendBookNumber:$scope.bookNumber,
                                        lendBookBorrower:lendBookBorrower
                                    };

                                    $http.post('/book/lendBook?lendBookName=' + $scope.bookName + '&lendBookNumber=' +$scope.bookNumber+ '&lendBookBorrower=' + lendBookBorrower)
                                        .success(function(data) {
                                            if (data.msg === 'bookNotExist') {
                                                $scope.clearMsg();
                                                showBook();
                                            } else if (data.msg === 'borrowerNotExist') {
                                                $scope.clearMsg();
                                                showBorrower();
                                            } else {
                                                fetchBooksList();
                                            }
                                        });
                                }
                            }]
                        });
                    }

                    //还书
                    if (book.lend == 1) {
                        ngDialog.open({
                            template: 'app/partials/bookView/returnBook.html',
                            controller: ['$scope', function($scope) {

                                $scope.bookName = book.bookName;
                                $scope.bookNumber = book.bookNumber;
                                $scope.borrowerName = '';

                                //获得借阅者
                                $http.post('/user/getBorrowerName?borrowerId=' + book.borrowId)
                                    .success(function (data) {
                                        $scope.borrowerName = data.borrowerName;
                                    });

                                $scope.returnBook = function() {
                                    $http.post('/book/returnBook?returnBookName=' + $scope.bookName + '&returnBookNumber=' + $scope.bookNumber)
                                        .success(function(data) {
                                            fetchBooksList();
                                            //closeThisDialog('123');
                                        });
                                };
                            }]
                        });
                    }
                });

        }

    });
