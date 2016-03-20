saApp.config(function ($stateProvider, ROLES) {
    $stateProvider
        .state('authorized', {
            abstract: true,
            data : {
                role: ROLES.AUTHORIZED
            },
            views: {
                "": {
                    templateUrl: "scripts/states/authorized/authorized.html"
                },
                "navigation@authorized": {
                    templateUrl: "scripts/states/authorized/navigation/navigation.html",
                    controller: "navigationCtrl"
                }
            }
        })
});