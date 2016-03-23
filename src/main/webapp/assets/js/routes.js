edtApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'pages/index.html',
                controller: 'HomeController'
            })
            .when('/error', {
                templateUrl: 'pages/error.html'
            })
            .otherwise({
                redirectTo: '/error'
            });
    }]);