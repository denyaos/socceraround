"use strict";

angular.module('saApp', [])
    .controller('MainController', function($http) {

        var ctrl = this;


        $http.get("/user/me").then(
            function(response) {
                ctrl.users = response.data;
            }
        );

        this.getUser = function(user) {
            $http.get("/player/" + user.id).then(
                function (response) {
                   ctrl.selectedUser = response.data;
                }
            );
        };

        this.login = function() {
          $http.post("/login", this.user);
        };

        this.register = function() {
            $http.post("/register", this.user);
        };

    });