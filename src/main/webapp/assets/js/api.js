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
            console.log("composantes chargées...");
            Loader.loadProfs();

        });
    },
    loadProfs: function () {
        $.get("/v1/prof", function (data) {
            Loader.vars.profs = data;
            console.log("profs chargés...");
            Loader.loadEnseignements();
        })
    },

    loadEnseignements: function () {
        $.get("/v1/enseignements", function (data) {
            Loader.vars.enseignements = data;
            console.log("enseignements chargés...");
            Loader.allLoaded();
        })
    },

    init: function ($scope) {
        Loader.scope = $scope;

        // load composantes
        Loader.loadComposantes();
    },


    scope: null,

    /**
     * Callback when all things are loaded
     * @param $scope
     */
    allLoaded: function () {
        createNotif("success", "Composants chargés.");
        // apply variables
        Loader.scope.loadedProfs = Loader.vars.profs;
        Loader.scope.loadedComposantes = Loader.vars.composantes;
        Loader.scope.loadedEnseignements = Loader.vars.enseignements;

    },

};

