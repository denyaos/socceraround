"use strict";

saApp.factory('AuthService', function ($http, $rootScope) {
    return {
        login: function(credentials) {
           $http({
               method: 'POST',
               url: '/login',
               data: transformFormToParams(credentials),
               headers: {'Content-Type': 'application/x-www-form-urlencoded'}
           }).then(function(){
               $rootScope.account = angular.copy(credentials);
           });
        },

        register: function(user) {
            $http.post("/register", user);
        }
    };

    function transformFormToParams(credentials) {
        var result = '';
        angular.forEach(credentials, function(value, key) {
            result += key + '=' + encodeURIComponent(value) + '&'
        });
        return result.length ? result.substr(0, result.length - 1): result;
    }
});
