<<<<<<< HEAD
var app = angular.module('Application', ['pascalprecht.translate','ngRoute', 'ngCookies', 'controllers', 'services']);

app.config(function ($translateProvider, $routeProvider, $httpProvider) {
=======
var app = angular.module('Application', ['ngRoute', 'ngCookies', 'controllers', 'services','directives', 'pascalprecht.translate']);

app.config(function ($routeProvider, $httpProvider, $translateProvider) {
>>>>>>> af47c496854401ba08e0003710a238f13f64872c

    $routeProvider
        .when('/', {
            templateUrl: '/resources/angular/home/home.html',
            controller: 'HomeController'
        })
        .when('/contact', {
            templateUrl: '/resources/angular/contact/contact.html',
            controller: 'ContactController'
        })
        .when('/registration', {
            templateUrl: '/resources/angular/registration/registration.html',
            controller: 'RegistrationController'
        });

    $httpProvider.defaults.headers.common = {Accept: "application/json"};
    $httpProvider.defaults.headers.post = {"Content-Type": "application/json;charset=utf-8"};
    $httpProvider.defaults.xsrfCookieName = 'XSRF-TOKEN';
    $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-Token';


    $translateProvider.useUrlLoader('/messageBundle');
    $translateProvider.useStorage('UrlLanguageStorage');
    $translateProvider.preferredLanguage('en');
    $translateProvider.fallbackLanguage('en');

});