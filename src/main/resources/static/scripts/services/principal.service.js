saApp.service('PrincipalService', function(ROLES){

    var account = null;

    this.isIdentified = function() {
        return !!account;
    };

    this.setAccount = function (data) {
        account = data;
    };

    this.setUnAuthenticated = function() {
        account = {
            authorities:[
                {name: ROLES.ANONYMOUS}
            ]
        };
    };

    this.getRoles = function() {
        return account.authorities
    }
});