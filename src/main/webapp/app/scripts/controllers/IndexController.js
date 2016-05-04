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
            console.log(postData);

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
        $scope.lendBook = function(lend) {
            var borrower = [];
            $http.get('user/getAllUser')
                .success(function(data){
                    borrower = data;
                });

            if (lend == 0) {
                ngDialog.open({
                    template: 'app/partials/bookView/lendBook.html',
                    controller: ['$scope', function($scope) {
                        // controller logic
                        $scope.bookName = '123';
                    }]
                });
            }

            if (lend == 1) {

            }
        }

    });
