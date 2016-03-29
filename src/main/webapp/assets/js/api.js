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
        $.get("/v1/composantes", function (data) {
            Loader.vars.composantes = data;
            createNotif("success", "Composantes chargées...");
        })
    },
    loadProfs: function () {
        $.get("/v1/profs", function (data) {
            Loader.vars.profs = data;
            createNotif("success", "Progs chargés...");
        })
    },

    init: function () {
        // load composantes
        Loader.loadComposantes();
    }

};

