saApp.controller('navigationCtrl', function ($scope, $rootScope, $state, AuthenticationClient) {

    $scope.logout = function () {
        AuthenticationClient.logout().then(
            function () {
                $rootScope.account = undefined;
                $state.go('welcome');
            }
        );
    };

});