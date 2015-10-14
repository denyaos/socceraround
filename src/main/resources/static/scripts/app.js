"use strict";

angular.module('saApp', [])
    .controller('MainController', function($http) {

        var ctrl = this;

        $http.get("/user").then(
            function(response) {
                ctrl.users = response.data;
            }
        );

        this.getUser = function(user) {
            $http.get("/user/" + user.id).then(
                function (response) {
                   ctrl.selectedUser = response.data;
                }
            );
        }

    });