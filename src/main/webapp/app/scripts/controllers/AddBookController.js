'use strict';
/**
 * @ngdoc function
 * @name MyLibraryApp.controller:AddBookController
 * @description
 * # AddBookController
 * Controller of the MyLibraryApp
 */
angular.module('MyLibraryApp')
    .controller('AddBookController', ['$scope', '$http', 'alertService', function ($scope, $http, alertService) {
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
                    if (data != null && data == "ok") {
                        console.log(data);
                        //$scope.alerts.push({type:'success',msg : '保存成功！'});
                        alertService.add('success', '保存成功！');
                        $scope.book = {};
                    } else {
                        alertService.add('danger', '保存失败，相同名称的书籍已存在！');
                        //$scope.alerts.push({type:'danger',msg : '保存失败，相同名称的书籍已存在！'});
                    }
                });
            }
        };

    }]);
