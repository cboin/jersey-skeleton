function doRemove(codeSeance) {
    alert(codeSeance + " removed!");
}


/**
 * First class which is called
 */
Loader = {
    vars: {
        composantes: [],
        profs: []
    },


    loadComposantes: function () {
        $.get("/v1/composantes", function(data){
            alert(data);
        })
    },

    init: function () {
        // load composantes
        Loader.loadComposantes();
    }

};

