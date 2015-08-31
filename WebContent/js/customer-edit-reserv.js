/**
 * Created by ABDULNAFEEZ on 8/26/2015.
 */
/**
 * Created by saramanzoor on 8/20/15.
 */

(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('customerEditCtrl', customerEditCtrl);

    customerEditCtrl.$inject = ['$scope', 'dataService', '$routeParams'];

    function customerEditCtrl($scope, dataService, $routeParams) {
        var customerEditVm = this;

        console.log("CustomerEditCtrl received" + $routeParams.confirmationNum);

        dataService.getStatus($routeParams.confirmationNum).then(function(data) {
            console.log("Payload" + data.payload);
            customerEditVm.editReservationObj = data.payload;
            console.log("Retrieved obj from URL to edit: "+ customerEditVm.editReservationObj.name);
            console.log("Date substring is: " + customerEditVm.editReservationObj.reservationTime.substring(11, 19));
            customerEditVm.date = customerEditVm.editReservationObj.reservationTime.substring(0, 10);
            customerEditVm.time = customerEditVm.editReservationObj.reservationTime.substring(11, 19);
        }, function(err) {
            console.log(err);
        });

        $scope.editReservation = function(editReservObj){
            editReservObj.reservationTime = customerEditVm.date + " " + customerEditVm.time;

            console.log("Inside customer edit ctrl editReservation " + editReservObj.reservationTime);
            console.log("Inside customer edit ctrl editReservation " + editReservObj.reservationStatus);

            dataService.updateReserv(editReservObj).then(function(data){
                console.log("Received success from editReserv ($updateReserv) service");
            }, function(error){
                console.log(error);
            });

        }


    }
})();