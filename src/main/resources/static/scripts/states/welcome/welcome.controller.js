saApp.controller('welcomeCtrl', function ($http, $scope, $rootScope, $state, AuthService) {

    //$scope.getUser = function (user) {
    //    $http.get("/player/" + user.id).then(
    //        function (response) {
    //            ctrl.selectedUser = response.data;
    //        }
    //    );
    //};

    $scope.login = function () {
        AuthService.login($scope.user);
            //.then(
            //function(){
            //    $state.go('base');
            //}
        //);
    };

    //$scope.register = function () {
    //    AuthService.register(this.registerUser);
    //};
});