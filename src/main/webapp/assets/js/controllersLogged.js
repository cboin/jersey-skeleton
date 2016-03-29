var edtControllers = angular.module('edtControllers', []);


edtControllers.controller('LoggedController', ['$scope', function ($scope) {
    changeTab("accueil");
}]);


edtControllers.controller('LogController', ['$scope', function ($scope, $token) {

}]);

edtControllers.controller('EDTController', function ($scope, $http) {
    changeTab("edt");

    Loader.init($scope);

    var EDITABLE = false;

    $("#modalDialog").hide();

    /**
     * Promotions
     */
    $http.get('v1/groupe').success(function (data) {
        $scope.promotions = data;

        $("#promotion").change(function () {

            var groupeId = $(this).val();


            EDITABLE = false;

            if (groupeId === "none" || groupeId.length == 0) {

                return;
            }

            $http.get('v1/cours/' + groupeId).success(function (dataCours) {
                EDITABLE = true;

                var l = dataCours.length;


                // all events
                $("#calendar").fullCalendar('removeEvents');

                // tous les cours
                var allCours = [];

                for (var i = 0; i < l; i++) {
                    var actuel = dataCours[i];
                    var cours = {};

                    cours.codeSeance = actuel.codeSeance;
                    cours.id = actuel.codeSeance;

                    /**
                     * Basic
                     * @type {string}
                     */
                    cours.title = actuel.nomGroupe + "\n" +
                        actuel.alias + "\n\n" +
                        actuel.nomProf + " - SALLE";


                    var date = actuel.dateSeance.substr(0, 11);


                    var startHour = returnHour(actuel.heureSeance);
                    var startDate = date + startHour;

                    var endHour = addHour(actuel.heureSeance, actuel.dureeSeance);
                    var endDate = date + endHour;


                    cours.start = startDate;
                    cours.end = endDate;


                    // plage horaire
                    actuel.plageHoraire = startHour + " -> " + endHour;


                    /**
                     * On save les différentes données transmises
                     */
                    cours.data = actuel;


                    allCours.push(cours);
                }

                $("#calendar").fullCalendar('addEventSource', allCours, true);

                $("#calendar").fullCalendar('rerenderEvents');


            });


        });


        function changeHoraire (calEvent, jsEvent, ui, view) {
            if (!EDITABLE) {
                return;
            }


            var start = calEvent.start;
            var end = calEvent.end;
            console.log(typeof start);

            // diff time
            var s = end.format('X') * 1 - start.format('X') * 1;
            var minutes = parseInt(s / 60);
            var heures = parseInt(minutes / 60);
            minutes = minutes % 60;

            if (minutes < 10) {
                minutes = "0" + minutes;
            }

            var duree = (heures + "" + minutes);


            // format string
            var heureDebut = start.format("H") + "" + start.format("mm");


            var codeSeance = calEvent.data.codeSeance;

            var d = {
                date: start.format(),
                heure: heureDebut,
                duree: duree
            };
            console.log(d);

            $http.post("/v1/seance/" + codeSeance + "/horaires", d, function (data) {
                createNotif("success", "Séance modifiée !");
            });

        }




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
            hiddenDays: [0],

            selectHelper: true,
            select: function (start, end) {

                $scope.infos = {
                    plageJour: start.format("DD/MM/YYYY") + " au " + end.format("DD/MM/YYYY"),
                    plageHoraire: start.format("HH:mm") + " -> " + end.format("HH:mm"),
                };
                $scope.$apply();

                $("#addSeance").modal('show');

                /*
                 var title = prompt('Nom de l\'événement:');
                 var eventData;
                 if (title) {
                 eventData = {
                 title: title,
                 start: start,
                 end: end
                 };
                 $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
                 }*/
                //  $('#calendar').fullCalendar('unselect');
            },

            /**
             * Click on event
             * @param calEvent
             * @param jsEvent
             * @param view
             */
            eventClick: function (calEvent, jsEvent, view) {
                if (!EDITABLE) {
                    return;
                }

                console.log($scope.loadedEnseignements);

                $("#modalDialog").hide();
                console.log(calEvent);

                $scope.infos = calEvent.data;

                $scope.$apply();

                $('#modalInfos').modal({});

                $("[data-id='remove']").off().on('click', function () {

                    // code seance
                    var codeSeance = calEvent.data.codeSeance;

                    // suppression
                    $http.delete("/v1/seance/" + codeSeance).then(function (d) {
                        createNotif("success", "Séance supprimée !");
                        $("#calendar").fullCalendar('removeEvents', codeSeance);
                        $("#calendar").fullCalendar('rerenderEvents');

                    }, function (fail) {
                        createNotif("danger", "Impossible de supprimer la séance...");
                    });

                    $("#modalInfos").modal('hide');

                });

            },

            /**
             * En cas de changement d'horaire
             */
            eventDrop: changeHoraire,
            eventResize: changeHoraire,

            selectable: true,
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

                //  $('#calendar').fullCalendar('gotoDate', date);
//                $('#calendar').fullCalendar('changeView', 'agendaDay');

            },
            // SlotEventOverlap : "false" ,
            timeFormat: 'HH:mm'
        });

    });


    // Watch for promo change
    $scope.$watch("selectPromo", function (newValue, oldValue) {
        if (typeof newValue === 'undefined' || newValue === 'none') {
            return;
        }
        Loader.loadEnseignements(newValue);
    })


    $("[data-id='save']").off().on('click', function () {

    });


});
