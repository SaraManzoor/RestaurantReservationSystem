/**
 * 
 */
(function() {
  'use strict';

  angular
    .module('plunker')
    .controller('reservCtrl', ReservController);

  ReservController.$inject = ['dataService'];

  function ReservController(dataService) {
    var reservVm = this;

    console.log('reserv-controller');

    dataService.title = 'reservCtrl has updated it';

    
    console.log(dataService);
    
    dataService.getReserv().then(function(data) {
    	console.log("Payload" + data.payload);
      reservVm.people = data.payload;
    }, function(err) {
      console.log(err);
    });

    console.log('here');
  }

})();