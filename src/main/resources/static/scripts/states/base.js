saApp.config(function ($stateProvider) {
    $stateProvider
        .state('base', {
            parent: 'authorized',
            url: '/profile',
            views: {
                "content@": { templateUrl: "scripts/states/base.html" }
            }
        })
});