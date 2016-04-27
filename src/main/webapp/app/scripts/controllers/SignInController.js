'use strict';
/**
 * @ngdoc function
 * @name MyLibraryApp.controller:SignInController
 * @description
 * # SignInController
 * Controller of the MyLibraryApp
 */
angular.module('MyLibraryApp')
    .controller('SignInController', function($scope) {
        $scope.user = {};
        $scope.submitForm = function(valid) {
            if(valid) {
                console.log('hello Angular!')
            }
        }
    });
