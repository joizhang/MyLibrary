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
        //console.log('123');

        $scope.book = {};
        $scope.alerts = [];

        $scope.addAlert = function(type, msg) {
            $scope.alerts.push({
                type: type,
                msg: msg
            });
        };

        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1)
        };

        //$scope.addAlert('danger', '保存失败，相同名称的书籍已存在！');

        $scope.bookFormSubmit = function (valid, book) {
            if (valid) {
                $http({
                    method: 'POST',
                    url: '/book/addBook',
                    data: angular.toJson($scope.book),
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
