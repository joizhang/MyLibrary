angular.module('MyLibraryApp')
    .controller('SignInController', function($scope) {
        $scope.user = {};
        $scope.submitForm = function(valid) {
            if(valid) {
                console.log('hello Angular!')
            }
        }
    });
