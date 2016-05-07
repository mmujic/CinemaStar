app.service('ContactService', ['$http', '$q', '$log', function ($http, $q, $log) {

    this.contactUs = function (contact) {

        var deferred = $q.defer();

        $http.post('/contact', contact, {  headers: { 'Content-Type': 'application/json' } }
        ).success(function () {
                deferred.resolve();
                $window.location.href = "/#/index";
            }).error(function (data, status, headers, config) {
                $log.log(data, status, headers, config);
                deferred.reject();
            });

        return deferred.promise;
    };

}]);