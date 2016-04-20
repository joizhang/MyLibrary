'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */
angular.module('MyLibraryApp')
    .directive('search',function(){
        return {
            templateUrl:'app/scripts/directives/search/search.html',
            restrict: 'E',
            replace: true,
        }
    });