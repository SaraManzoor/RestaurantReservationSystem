/**
 * Created by saramanzoor on 8/20/15.
 */

(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('custProfileCtrl', custProfileCtrl);

    custProfileCtrl.$inject = ['$scope', 'dataService', '$routeParams'];

    function custProfileCtrl(scope, dataService, $routeParams) {
        var custProfileVm = this;

        console.log('reserv-controller');

        console.log("$routeParams.confirmationNum" + $routeParams.confirmationNum);

        dataService.title = 'reservCtrl has updated it';

        console.log(dataService);

        dataService.getStatus($routeParams.confirmationNum).then(function(data) {
            console.log("Payload" + data.payload);
            custProfileVm.reservation = data.payload;
        }, function(err) {
            console.log(err);
        });
        


        console.log('here');
    }
})();