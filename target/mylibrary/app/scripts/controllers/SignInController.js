angular.module('MyLibraryApp')
    .controller('SignInController', function($scope,$position) {
        $scope.user = {'username': 123};
        $scope.submitForm = function(valid) {
            if(valid) {
                console.log('hello Angular!')
            }
        }
    });
