'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */
angular.module('MyLibraryApp')
	.directive('header',function(){
		return {
        templateUrl:'app/scripts/directives/header/header.html',
        restrict: 'E',
        replace: true,
    	}
	});


