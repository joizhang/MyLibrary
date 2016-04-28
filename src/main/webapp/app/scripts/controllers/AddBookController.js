'use strict';
/**
 * @ngdoc function
 * @name MyLibraryApp.controller:AddBookController
 * @description
 * # AddBookController
 * Controller of the MyLibraryApp
 */
angular.module('MyLibraryApp')
    .controller('AddBookController', function($scope, $http) {
        $scope.book = {};

        $scope.alerts = [];

        $scope.bookFormSubmit = function(valid, book) {
            if(valid) {
                console.log($.param($scope.book));
                console.log($scope.book);
                console.log(angular.toJson($scope.book));
                $http({
                    method: 'POST',
                    url: '/book/addBook',
                    data: angular.toJson($scope.book),
                }).success(function(data, status) {
                    console.log(data);
                    if(data === "ok") {
                        $scope.alerts.push({type:'success',msg : '保存成功！'});
                        $scope.book = {};
                    } else {
                        $scope.alerts.push({type:'danger',msg : '保存失败，相同名称的书籍已存在！'});
                    }
                });
            }
        };

        $scope.close = function() {
            console.log('test');
            //$scope.alerts.splice(index, 0);
        };
    });
