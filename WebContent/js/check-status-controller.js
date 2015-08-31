/**
 * 
 */
(function() {
  'use strict';

  angular
    .module('plunker')
    .controller('checkStatusCtrl', checkStatusController);

  checkStatusController.$inject = ['$scope', 'dataService'];

  function checkStatusController($scope, dataService) {
    var checkStatusVm = this;

    checkStatusVm.name = "Angular";
    console.log('check-status-controller');

    dataService.title = 'reservCtrl has updated it';
   
    console.log(dataService);
 
    $scope.check = function(confirmationNumb){
    	dataService.getStatus(confirmationNumb).then(function(data) {
        	console.log("Payload" + data.payload);
        	checkStatusVm.reservation = data.payload;
        }, function(err) {
          console.log(err);
        });
    }
    
    $scope.login = function(user){
        loginService.login(user); //call login service
    }

    checkStatusVm.customerEditReserv = function(reserv){
      console.log('Inside customerEditReservFunc :' + reserv.name);
      $scope.customerEditReservObj = reserv;
    }
    

    console.log('here');
  }

})();