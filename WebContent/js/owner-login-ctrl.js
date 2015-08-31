/**
 * Created by saramanzoor on 8/30/15.
 */
(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('ownerLoginCtrl', ownerLoginCtrl);

    ownerLoginCtrl.$inject = ['dataService', '$scope', '$routeParams', '$rootScope', '$location'];

    function ownerLoginCtrl(dataService, $scope, $routeParams, $rootScope, $location) {
        var ownerLoginVm = this;

        ownerLoginVm.checkAuth = function(){
            console.log("Inside check auth function ctrl");
            if(ownerLoginVm.username == "admin" && ownerLoginVm.password == "admin"){
                console.log("Success");
                $location.path('/view-reservation');
                ownerLoginVm.authResult = "Success";
            }
            else{
                console.log("Failure");
                ownerLoginVm.authResult = "Try again!";
            }
        }

    }
})();