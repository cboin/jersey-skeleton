edtApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'pages/login.html',
                controller: 'HomeController'
            })
            .when('/error', {
                templateUrl: 'pages/error.html'
            })
            .otherwise({
                redirectTo: '/error'
            });
    }]);