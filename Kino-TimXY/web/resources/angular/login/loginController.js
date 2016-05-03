app.controller("LoginController", ['$scope', '$log', 'LoginService',
    function ($scope, $log, LoginService) {

        $scope.error = false;

        $scope.user = {
            username: "",
            password: ""
        };

        $scope.login = function(event) {
            event.preventDefault();
            valid = LoginService.checkLogin($scope.user);
            if(valid) {
                angular.element(loginForm)[0].submit();
            } else {
                $scope.error = true;
            }
        }
    }]);