app.controller("LoginController", ['$scope', '$log', 'LoginService', '$window',
    function ($scope, $log, LoginService, $window) {

        $scope.csrfValue = $window.document.getElementsByName('_csrf')[0].content;

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