/**
 * Created by saramanzoor on 8/27/15.
 */

/**
 *
 */
(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('restProfileCtrl', RestProfileCtrl);

    RestProfileCtrl.$inject = ['$scope', 'dataService', '$routeParams'];

    function RestProfileCtrl($scope, dataService, $routeParams) {
        var restProfileVm = this;

        console.log('rest-edit-controller'+ $routeParams.restID);


        dataService.getRestDetails($routeParams.restID).then(function(data) {
            console.log("Payload" + data.payload.restName);
            restProfileVm.editRestaurantObj = data.payload;
        }, function(err) {
            console.log(err);
        });

        $scope.updateRestaurant = function(restObj){

            console.log("Inside owner rest profile edit ctrl " + restObj.restName);

            dataService.updateRestaurantDetails(restObj).then(function(data){
                console.log("Received success from updateRestaurant ($updateRest) service");
            }, function(error){
                console.log(error);
            });

        }
        //
        //console.log('here');
    }

})();