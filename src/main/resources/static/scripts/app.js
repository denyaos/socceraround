"use strict";

var saApp = angular.module('saApp', []);

saApp.controller('MainController', function ($http, $rootScope, AuthService) {

    var ctrl = this;

    $http.get("/me").then(
        function (response) {
            $rootScope.currentUser = response.data;
        },
        function (error) {
            console.log(error);
        }
    );

    this.getUser = function (user) {
        $http.get("/player/" + user.id).then(
            function (response) {
                ctrl.selectedUser = response.data;
            }
        );
    };

    this.login = function () {
        AuthService.login(this.loginUser);
    };

    this.register = function () {
        AuthService.register(this.registerUser);
    };
});
