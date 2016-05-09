'use strict';
/**
 * @ngdoc function
 * @name MyLibraryApp.controller:AddBookController
 * @description
 * # AddBookController
 * Controller of the MyLibraryApp
 */
angular.module('MyLibraryApp')
    .controller('AddBookController', ['$scope', '$http', function ($scope, $http) {

        var bookTypes = [];
        $scope.bookTypeExist = false;
        $scope.book = {};
        $scope.alerts = [];

        $scope.clearBookTypeMsg = function() {
            $scope.bookTypeExist = false;
        };
        var showBookTypeWarning = function() {
            $scope.bookTypeExist = true;
        };

        //添加通知栏
        $scope.addAlert = function(type, msg) {
            $scope.alerts.push({
                type: type,
                msg: msg
            });
        };
        //关闭通知栏
        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1)
        };

        //获得所有书籍类型
        $http.get('/bookType/getAllBookType')
            .success(function(data) {
                //console.log(data);
                bookTypes = data;
            });
        //检查书籍类型是否存在
        $scope.checkBookType = function(bookType) {
            $http.get('/bookType/getBookType?bookType=' + bookType)
                .success(function(data) {
                    //console.log(data.bookType == null);
                    if (data.bookType == null) {
                        showBookTypeWarning();
                    }
                });
        };

        $scope.bookFormSubmit = function (valid, book) {
            //console.log(angular.toJson($scope.book));
            if (valid) {
                $http({
                    method: 'POST',
                    url: '/book/addBook',
                    data: angular.toJson($scope.book)
                }).success(function (data) {
                    //console.log(data);
                    if (data != null && data.msg === 'success') {
                        //$scope.addAlert('success', '保存失败，相同名称的书籍已存在！');
                        $scope.book = {};
                    } else {
                        $scope.addAlert('danger', '保存失败，相同名称的书籍已存在！');
                    }
                });
            }
        };



    }]);
