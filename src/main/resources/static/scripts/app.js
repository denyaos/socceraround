"use strict";

var saApp = angular.module('saApp', ['ui.router']);

saApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/");

});