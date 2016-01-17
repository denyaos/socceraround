saApp.config(function ($stateProvider) {
    $stateProvider
        .state('authorized', {
            abstract: true,
            views: {
                "navigation": { templateUrl: "scripts/states/navigation.html" }
            }
        })
});