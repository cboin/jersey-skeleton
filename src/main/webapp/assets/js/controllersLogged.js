var edtControllers = angular.module('edtControllers', []);


edtControllers.controller('LoggedController', ['$scope', function ($scope) {
}]);


edtControllers.controller('LogController', ['$scope', function ($scope, $token) {

}]);

edtControllers.controller('EDTController', function ($scope, $http) {

    /**
     * Promotions
     */
    $http.get('v1/groupe').success(function (data) {
        console.log(data);
        $scope.promotions = data;


        $("#promotion").change(function(){

            // on affiche le calendrier en selectionnant la promo
            $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay'
                },
                scrollTime: '12:00:00', //Determines how far down the scroll pane is initially scrolled down


                minTime: "08:00:00",
                maxTime: "21:00:00",

                defaultView: 'agendaWeek',
                editable: false,
                eventLimit: true, // allow "more" link when too many events
                lang: 'fr',
                weekNumbers: true,
                eventTextColor: "black",
                eventBorderColor: "black",
                color: "lightgrey",
                height: "auto",
                dayClick: function (date, jsEvent, view) {

                    $('#calendar').fullCalendar('gotoDate', date);
                    $('#calendar').fullCalendar('changeView', 'agendaDay');

                },
                // SlotEventOverlap : "false" ,
                timeFormat: 'HH:mm'
            });
        });


    });




});



