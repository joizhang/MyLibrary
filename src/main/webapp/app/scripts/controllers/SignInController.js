angular.module('MyLibraryApp')
    .controller('SignInController', function($scope,$position) {
        $scope.user = {};
        $scope.submitForm = function(valid) {
            if(valid) {
                console.log('hello Angular!')
            }
        }
    });
