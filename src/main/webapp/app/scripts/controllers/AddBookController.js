'use strict';
/**
 * @ngdoc function
 * @name sbAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sbAdminApp
 */
angular.module('MyLibraryApp')
    .controller('AddBookController', function($scope, $http) {
        $scope.book = {};
        $scope.bookFormSubmit = function(valid, book) {
            if(valid) {
                console.log($scope.book);
                $http({
                    method: 'post',
                    url: 'app/book/addBook',
                    headers: {'Content-Type': 'multipart/form-data'},
                    data: $scope.book,
                    transformRequest: function(data, headersGetterFunction) {
                        return data; // do nothing! FormData is very good!
                    }
                }).success(function(data, status) {
                    console.log('success');
                });
            }
        }
    });
