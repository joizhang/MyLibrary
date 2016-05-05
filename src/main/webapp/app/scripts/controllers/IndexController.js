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
            //console.log(postData);

            $http.post('/book/bookList?currentPage=' + $scope.paginationConf.currentPage + '&itemsPerPages=' + $scope.paginationConf.itemsPerPages)
                .success(function(data){
                    //console.log(data.dataList)
                    $scope.books = data.dataList;
                    $scope.paginationConf.totalItems = data.totalRecord;
                    //console.log($scope.paginationConf);
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
            console.log(bookId);
            $http.post('/book/deleteBook/' + bookId)
                .success(function(data){
                    if (data.msg === "success") {
                        fetchBooksList();
                    }
                });
        };

        //格式化借出
        $scope.formatLend = function(lend) {
            if (lend == 0)
                return '<i class="fa fa-minus"></i> 借出';

            if (lend == 1)
                return '<i class="fa fa-plus"></i> 返还';
        };

        //借书和还书
        $scope.lendBook = function(book, target) {
            var borrowerNames = [];
            var test = ['Alabama', 'Alaska'];
            //console.log(test);
            console.log(target.getAttribute("ng-bind-html"));
            $http.get('/user/getAllUserName')
                .success(function(data){
                    borrowerNames = data;
                    //console.log(borrowerNames);

                    if (book.lend == 0) {
                        ngDialog.open({
                            template: 'app/partials/bookView/lendBook.html',
                            controller: ['$scope', function($scope) {
                                // controller logic
                                $scope.bookName = book.bookName;
                                $scope.bookNumber = book.bookNumber;
                                $scope.borrowerNames = borrowerNames;
                                //console.log('lalalal' + $scope.borrowers);

                                $scope.submitLendBookForm = function(valid, lendBook) {
                                    var postBook = [
                                        {name:'lendBookName', value:lendBook.lendBookName},
                                        {name:'lendBookNumber', value:lendBook.lendBookNumber},
                                        {name:'lendBookBorrower', value:lendBook.lendBookBorrower}
                                    ];
                                    console.log(postBook);
                                    $http.post('/book/lendBook', postBook)
                                        .success(function(data) {
                                            console.log('121212');
                                        });
                                }
                            }]
                        });
                    }

                    if (book.lend == 1) {

                    }
                });

        }

    });
