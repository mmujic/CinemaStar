app.service('RegistrationService', ['$http', '$q', '$log', '$window', function ($http, $q, $log, $window) {

    this.createNewUser = function (user) {

        var deferred = $q.defer();

        $http.post('/user', user, {  headers: { 'Content-Type': 'application/json' } }
            ).success(function () {
                deferred.resolve();
                $window.location.href = "/#/login/confirm";
            }).error(function (data, status, headers, config) {
                $log.log(data, status, headers, config);
                deferred.reject();
            });

        return deferred.promise;
    };

}]);