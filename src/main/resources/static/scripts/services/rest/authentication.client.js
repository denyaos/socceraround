saApp.service('AuthenticationClient', function($q, $http) {

    this.authenticate = function(credentials) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            url: '/login',
            data: transformFormToUrlParams(credentials),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function(){
            deferred.resolve();
        }, function(){
            deferred.reject();
        });
        return deferred.promise;
    };

    this.logout = function() {
        return $http.post("/logout");
    };

    function transformFormToUrlParams(credentials) {
        var result = '';
        angular.forEach(credentials, function(value, key) {
            result += key + '=' + encodeURIComponent(value) + '&'
        });
        return result.length ? result.substr(0, result.length - 1) : result;
    }



});