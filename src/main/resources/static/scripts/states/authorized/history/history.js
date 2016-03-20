saApp.config(function ($stateProvider) {
    $stateProvider
        .state('history', {
            parent: 'authorized',
            url:'/history',
            views: {
                "content": {
                    templateUrl: "scripts/states/authorized/history/history.html"
                }
            }

        })
});