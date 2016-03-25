var edtControllers = angular.module('edtControllers', []);


edtControllers.controller('LoggedController', ['$scope', function ($scope) {
}]);


edtControllers.controller('LogController', ['$scope', function ($scope, $token) {

}]);

edtControllers.controller('EDTController', function ($scope, $http) {

     $("#calendar").hide();

    /**
     * Promotions
     */
    $http.get('v1/groupe').success(function (data) {
        $scope.promotions = data;


        $("#promotion").change(function () {
            $("#calendar").hide();

            var groupeId = $(this).val();

            $http.get('v1/cours/' + groupeId).success(function (dataCours) {

                var l = dataCours.length;


                // all events
                $("#calendar").fullCalendar('removeEvents');

                // tous les cours
                var allCours = [];

                for (var i = 0; i < l; i++) {
                    var actuel = dataCours[i];
                    var cours = {};

                    cours.title = actuel.nomGroupe + "\n" +
                        actuel.alias + "\n\n" +
                        actuel.nomProf + " - SALLE";


                    var date = actuel.dateSeance.substr(0, 11);


                    var startDate = date + returnHour(actuel.heureSeance);
                    var endDate = date + addHour(actuel.heureSeance, actuel.dureeSeance);


                    cours.start = startDate;
                    cours.end = endDate;

                    // $("#calendar").fullCalendar('renderEvent', cours, true);

                    allCours.push(cours);
                }

                $("#calendar").fullCalendar('addEventSource', allCours)
                $("#calendar").fullCalendar( 'rerenderEvents' );

                $("#calendar").show();


            });


        });

        // on affiche le calendrier en selectionnant la promo
        $('#calendar').fullCalendar({
            events: [],
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            scrollTime: '12:00:00', //Determines how far down the scroll pane is initially scrolled down


            minTime: "08:00:00",
            maxTime: "21:00:00",

            defaultView: 'agendaWeek',

            selectable: true,
            selectHelper: true,
            select: function (start, end) {
                var title = prompt('Nom de l\'événement:');
                var eventData;
                if (title) {
                    eventData = {
                        title: title,
                        start: start,
                        end: end
                    };
                    $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
                }
                $('#calendar').fullCalendar('unselect');
            },
            editable: true,
            eventLimit: true,

            lang: 'fr',
            weekNumbers: true,
            eventTextColor: "black",
            eventBorderColor: "black",
            color: "lightgrey",
            height: "auto",
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


function returnHour(string) {
    if (typeof string === "undefined") {
        console.error("erreur indefinie");
        return "000000";
    }

    string = "" + string;

    if (string.length == 3) {
        return "0" + string.substring(0, 1) + ":" + string.substring(1, 3) + ":00";
    }
    return string.substring(0, 2) + ":" + string.substring(2, 4) + ":00";
}


function addHour(string, duree) {

    string = "" + string;
    duree = "" + duree;

    var h = "" + (string * 1 + duree * 1);
    var heure = 0;
    var minutes = 0;

    if (h.length == 3) {
        heure = h.substring(0, 1) * 1;
        minutes = h.substring(1, 3) * 1;
    } else {
        heure = h.substring(0, 2) * 1;

        minutes = h.substring(2, 4) * 1;
    }

    heure += parseInt(minutes / 60);
    minutes = minutes % 60;


    if (heure < 10) {
        heure = "0" + heure;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }

    return heure + ":" + minutes + ":00";
}

