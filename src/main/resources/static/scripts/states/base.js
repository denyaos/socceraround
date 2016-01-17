saApp.config(function ($stateProvider) {

    $stateProvider
        .state('base', {
            url: "/",
            views: {
                "navigation": { templateUrl: "scripts/states/navigation.html" },
                "content": { templateUrl: "scripts/states/base.html" }
            }
            //templateUrl: "scripts/states/base.html",
            //controller: function ($scope) {
            //    $scope.items = ["A", "List", "Of", "Items"];
            //}
        })
});