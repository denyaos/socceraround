"use strict";

var saApp = angular.module('saApp', ['ui.router']);

saApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/");


});

saApp.run(function($rootScope, $http, $state, AuthService){

    $rootScope.$on('$stateChangeStart',
        function(event, toState, toParams, fromState, fromParams){
            AuthService.authorizeState(toState);
        }
    );


});