"use strict";

saApp.factory('AuthService', function ($q, $http, $filter, $state, ROLES,
                                       PrincipalService, AuthenticationClient) {

    return {
        authorizeState: function(toState) {
            userHasAccess(toState).then(function (has) {
                if (!has)
                    goHomeState();
            })
        },

        login: function(credentials) {
            AuthenticationClient.authenticate(credentials)
                .then(this.resolveAuthentication)
                .then(function() {
                    goHomeState()
                },
                function (){
                    //todo: show bad login message
                }
            )
        },

        register: function(user) {
            $http.post("/register", user);
        }
    };

    function resolveAuthentication() {
        var deferred = $q.defer();
        if (PrincipalService.isIdentified()) {
            console.log('Info! in: Auth service, resolveAuthentication. authentication got from rootScope');
            deferred.resolve();
        } else {
            $http.get("/me", {ignoreErrors: true}).then(
                function (response) {
                    PrincipalService.setAccount(response.data);
                    deferred.resolve();
                },
                function () {
                    PrincipalService.setUnAuthenticated();
                    deferred.resolve()
                }
            );
        }
        return deferred.promise;
    }

    function userHasAccess(toState) {
        var deferred = $q.defer();
        if (toState.data && toState.data.role) {
            resolveAuthentication().then(function(){
                deferred.resolve(hasAccountRole(toState.data.role));
            });
        } else {
            deferred.resolve(true);
        }
        return deferred.promise;
    }

    function goHomeState() {
        resolveAuthentication().then(function(){
            var toState;
            if (hasAccountRole(ROLES.ANONYMOUS))
                toState = 'welcome';
            else if (hasAccountRole(ROLES.PLAYER))
                toState = 'history';
            $state.go(toState);
        })
    }

    function hasAccountRole(role) {
        var roles = PrincipalService.getRoles();
        var b = $filter('filter')(roles, {name: role}).length > 0;
        return b;
    }
});
