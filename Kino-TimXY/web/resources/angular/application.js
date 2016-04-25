var app = angular.module('Application', ['ngRoute', 'ngCookies']);

app.config(function ($routeProvider, $httpProvider) {

    $routeProvider
        .when('/', {
            templateUrl: '/resources/angular/home/home.html',
            controller: 'HomeController'
        })
        .when('/contact', {
            templateUrl: '/resources/angular/contact/contact.html',
            controller: 'ContactController'
        });

    $httpProvider.defaults.headers.common = {Accept: "application/json"};
    $httpProvider.defaults.headers.post = {"Content-Type": "application/json;charset=utf-8"};
    $httpProvider.defaults.xsrfCookieName = 'XSRF-TOKEN';
    $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-Token';

});

var token;
var header;
app.run(function run( $http, $cookies ){
    if($cookies._csrf != undefined) {
        token = $cookies._csrf;
    }
});
