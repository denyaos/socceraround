saApp.config(function ($stateProvider, ROLES) {
    $stateProvider
        .state('welcome', {
            url:'/',
            data : {
                role: ROLES.ANONYMOUS
            },
            templateUrl: "scripts/states/welcome/welcome.html",
            controller: 'welcomeCtrl'
        })
});