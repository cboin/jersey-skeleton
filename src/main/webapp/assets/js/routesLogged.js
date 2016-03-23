/**
 * On est sur la page logged.html
 */
edtApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'pages/logged/index.html',
                controller: 'LoggedController'
            })
            .when('/log/:token', {
                controller: 'LogController'
            })
            .when('/error', {
                templateUrl: 'pages/error.html'
            })
            .otherwise({
                redirectTo: '/error'
            });
    }]);