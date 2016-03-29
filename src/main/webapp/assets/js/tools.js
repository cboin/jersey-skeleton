/**
 * Created by Pierre on 23/03/2016.
 */
function createNotif(type, message){
    $("#alertNotif").hide().removeClass('alert-danger, alert-success, alert-info, alert-warning').addClass('alert-'+type).html(message).removeClass('hidden').slideDown('slow');
}



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


function changeTab(name) {
    $(".active[data-lien]").removeClass('active');
    $("[data-lien='" + name + "']").addClass('active');
}