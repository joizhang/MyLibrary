'use strict';
/**
 * @ngdoc function
 * @name MyLibraryApp.controller:IndexController
 * @description
 * # IndexController
 * Controller of the MyLibraryApp
 */
angular.module('MyLibraryApp')
    .controller('IndexController', function($scope, $http, $position) {
        $scope.fetchBooksList = function() {
            $http.get('app/data/bookList.json')
                .success(function(response){
                    $scope.books = response.bookList;
                    console.log('success123');
                });
        };

        $scope.fetchBooksList();
    });
