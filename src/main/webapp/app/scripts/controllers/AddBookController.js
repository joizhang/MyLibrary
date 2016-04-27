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
        $scope.bookFormSubmit = function(valid, book) {
            if(valid) {
                //console.log($.param($scope.book));
                //console.log($scope.book);
                //console.log(angular.toJson($scope.book));
                $http({
                    method: 'POST',
                    url: '/book/addBook',
                    data: angular.toJson($scope.book),
                }).success(function(data, status) {
                    console.log('success');
                });
            }
        }
    });
