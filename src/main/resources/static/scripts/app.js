"use strict";

var saApp = angular.module('saApp', ['ui.router']);

saApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/");

});


//saApp.controller('MainController', function ($http, $scope, $rootScope, AuthService) {
//
//    $http.get("/me").then(
//        function (response) {
//            $rootScope.account = response.data;
//        },
//        function (error) {
//            console.log(error);
//        }
//    );
//
//    $scope.getUser = function (user) {
//        $http.get("/player/" + user.id).then(
//            function (response) {
//                ctrl.selectedUser = response.data;
//            }
//        );
//    };
//
//    $scope.login = function () {
//        AuthService.login(this.loginUser);
//    };
//
//    $scope.register = function () {
//        AuthService.register(this.registerUser);
//    };
//});
