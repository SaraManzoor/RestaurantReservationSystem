/**
 *
 */
(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('ownerCtrl', ownerController);

    ownerController.$inject = ['$scope', 'dataService', '$rootScope'];

    function ownerController($scope, dataService, $rootScope) {
        var ownerVm = this;

        //ownerVm.allReservations =[];


        dataService.getAllReserv().then(function (data) {
            ownerVm.allReservations = data.payload;
            console.log("Inside owner controller"+ data.payload);
        }, function (err) {
            console.log(err);
        });

        ownerVm.selectedReservObj = {};

        ownerVm.setSelectedReservObj = function(p){
            console.log("Inside mediator- passed obj " + p.name);
            ownerVm.selectedReservObj = p;
            $scope.ownerSelectedThisObj = p;

        };

        ownerVm.confirmReserv = function(){
            console.log("Inside confirm reserv - owner");

            dataService.assignTable().then(function (data) {


            }, function (err) {
                console.log(err);
            });
        };

        ownerVm.deleteReservation = function(confirmNum){
            dataService.deleteReserv(confirmNum).then(function (data) {
                ownerVm.allReservations = data.payload;
                console.log("Inside owner controller: Deleted reservation"+ data.payload);
            }, function (err) {
                console.log(err);
            });
        };

        $scope.assignTableObj = function(reservObj){
            console.log("you clicked on "+ reservObj.name);
            $rootScope.ownerSelectedObj = reservObj;
        };
    }

})();