function doRemove(codeSeance) {
    alert(codeSeance + " removed!");
}


/**
 * First class which is called
 */
Loader = {
    vars: {
        composantes: [],
        profs: [],
        enseignements: []
    },

    nbLoaded: 0,


    loadComposantes: function () {
        $.get("/v1/composantes", function (data) {
            Loader.vars.composantes = data;
            createNotif("success", "Composantes chargées...");
            Loader.allLoaded();

        })
    },
    loadProfs: function () {
        $.get("/v1/prof", function (data) {
            Loader.vars.profs = data;
            createNotif("success", "Profs chargés...");
            Loader.allLoaded();
        })
    },

    loadEnseignements: function () {
        $.get("/v1/enseignements", function (data) {
            Loader.vars.profs = data;
            createNotif("success", "Enseignements chargés...");
            Loader.allLoaded();
        })
    },

    init: function ($scope) {
        Loader.scope = $scope;

        // load composantes
        Loader.loadComposantes();
        Loader.loadProfs();
        Loader.loadEnseignements();
    },


    scope: null,
    /**
     * Callback when all things are loaded
     * @param $scope
     */
    allLoaded: function () {
        Loader.nbLoaded++;
        if (Loader.nbLoaded >= 3) {
            // apply variables
            Loader.scope.loadedProfs = Loader.vars.profs;
            Loader.scope.loadedComposantes = Loader.vars.composantes;
            Loader.scope.loadedEnseignments = Loader.vars.enseignements;

        }
    },

};

