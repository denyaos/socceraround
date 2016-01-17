saApp.controller('welcomeCtrl', function ($http, $scope, $rootScope, $state, AuthService) {

    $http.get("/me").then(
        function (response) {
            $rootScope.account = response.data;
        },
        function (error) {
            console.log(error);
        }
    );

    $scope.getUser = function (user) {
        $http.get("/player/" + user.id).then(
            function (response) {
                ctrl.selectedUser = response.data;
            }
        );
    };

    $scope.login = function () {
        AuthService.login(this.user).then(
            function(){
                $state.go('base');
            }
        );
    };

    //$scope.register = function () {
    //    AuthService.register(this.registerUser);
    //};
});