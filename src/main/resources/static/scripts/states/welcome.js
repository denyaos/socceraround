saApp.config(function ($stateProvider) {
    $stateProvider
        .state('welcome', {
            url:'/',
            views: {
                "content": { templateUrl: "scripts/states/welcome.html" }
            }
        })
});