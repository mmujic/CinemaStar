app.controller("HomeController", ['$scope', '$filter', '$log', "HomeService", "$window",
    function ($scope, $filter, $log, HomeService, $window) {

        $scope.movies = [];

        HomeService.getAllMovies().then(function (data) {
            $scope.movies = data;
        }, function() {
            $window.location.replace('/403')}
            );
        HomeService.createMovie();
    }]);