<<<<<<< HEAD
var services = angular.module('services', []);
=======
var services = angular.module('services', ['ngResource']);
>>>>>>> af47c496854401ba08e0003710a238f13f64872c

services.factory('UrlLanguageStorage', ['$location', function ($location) {
    return {
        set: function (name, value) {
        },
        get: function (name) {
            return $location.search()['lang']
        }
    };
}]);
