app.service('LoginService', ['$http', '$q', '$log', '$window', function ($http, $q, $log, $window) {

    this.checkLogin = function (user) {
        var deferred = $q.defer();
        if(user.username == null || user.username == "" || user.password == null || user.password == "") {
            return false;
        }

        $http.post('/user/login', user, {  headers: { 'Content-Type': 'application/json' } }
            ).success(function () {
                deferred.resolve(true);
            }).error(function (data, status, headers, config) {
                $log.log(data, status, headers, config);
                deferred.error(false);
            });
        return deferred.promise;
    };

    this.login = function (user) {

            var deferred = $q.defer();

            $http.post('j_spring_security_check', user, {  headers: { 'Content-Type': 'application/x-www-form-urlencoded' } }
                ).success(function () {
                    deferred.resolve();
                    $window.location.href = '/';
                }).error(function (data, status, headers, config) {
                    $log.log(data, status, headers, config);
                    deferred.reject();
                });

            return deferred.promise;
        };

}]);