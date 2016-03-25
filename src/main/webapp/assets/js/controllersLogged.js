var edtControllers = angular.module('edtControllers', []);


edtControllers.controller('LoggedController', ['$scope', function ($scope) {
}]);


edtControllers.controller('LogController', ['$scope', function ($scope, $token) {

}]);

edtControllers.controller('EDTController', ['$scope', function ($scope, $token) {


    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        // defaultDate: '2015-09-01',
        scrollTime: '08:00:00', //Determines how far down the scroll pane is initially scrolled down
        // start: '10:00', // a start time
        // end: '16:00', // an end time
        defaultView: 'agendaWeek',
        editable: false,
        eventLimit: true, // allow "more" link when too many events
        lang: 'fr',
        weekNumbers: true,
        eventTextColor: "black",
        eventBorderColor: "black",
        color: "lightgrey",
        dayClick: function (date, jsEvent, view) {

            $('#calendar').fullCalendar('gotoDate', date);
            $('#calendar').fullCalendar('changeView', 'agendaDay');

        },
        // SlotEventOverlap : "false" ,
        timeFormat: 'HH:mm'
    });


}])
;



