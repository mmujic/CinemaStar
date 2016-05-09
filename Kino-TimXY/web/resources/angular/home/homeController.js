app.controller("HomeController", ['$scope','$filter', '$log', "HomeService", "$http", "$window",
    function ($scope, $filter, $log, HomeService, $http, $window) {

        //$scope.movies = [{value: 'item1'}, {value: 'item2'}, {value: 'item3'}];
        $scope.movies = [];
        HomeService.getAllMovies().then(function (data) {
            $scope.movies = data;
            $scope.extraData = [];

            for (var i=0; i<$scope.movies.length; i++) {
                (function(i) {
                    $scope.search = $scope.movies[i].name;
                    $scope.details = "";

                    $http.get("http://www.omdbapi.com/?t=" + $scope.search + "&tomatoes=true&plot=full")
                        .then(function (response) {
                            $scope.details = response.data;
                            $scope.movies[i].rating = $scope.details.imdbRating;
                            //$scope.extraData.push($scope.movies[i].name);
                        });
                })(i);
            }
        }, function() {
            $window.location.replace('/403')}
            );


            //$scope.search = movies[i].name;
            //$scope.details = "";

            //$http.get("http://www.omdbapi.com/?t=" + $scope.search + "&tomatoes=true&plot=full")
            //    .then(function(response){
            //        $scope.details = response.data;
            //    });

            //$scope.extraData.push($scope.details.imdbRating);
                //"tomatoR": $scope.details.tomatoRating,
                //"poster": $scope.details.Poster


    }]);