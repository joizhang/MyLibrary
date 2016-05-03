'use strict';
/**
 * @ngdoc function
 * @name MyLibraryApp.controller:AddBookController
 * @description
 * # AddBookController
 * Controller of the MyLibraryApp
 */
angular.module('MyLibraryApp')
    .controller('AddBookController', ['$scope', '$http', 'commAlertService', function ($scope, $http, commAlertService) {
        $scope.book = {};

        $scope.bookFormSubmit = function (valid, book) {
            if (valid) {
                //console.log($.param($scope.book));
                //console.log($scope.book);
                //console.log(angular.toJson($scope.book));
                $http({
                    method: 'POST',
                    url: '/book/addBook',
                    data: angular.toJson($scope.book),
                }).success(function (data) {
                    if (data != null && data === '"success"') {
                        console.log(data);
                        //commAlertService.alertService().add('success', '保存成功！');
                        $scope.book = {};
                    } else {
                        commAlertService.alertService().add('danger', '保存失败，相同名称的书籍已存在！');
                    }
                });
            }
        };

        $scope.test = function() {
            console.log('123');
        };
    }]);
