/**
 * Created by Pierre on 23/03/2016.
 */
function createNotif(type, message){
    $("#alertNotif").hide().removeClass('alert-danger, alert-success, alert-info, alert-warning').addClass('alert-'+type).html(message).removeClass('hidden').slideDown('slow');
}