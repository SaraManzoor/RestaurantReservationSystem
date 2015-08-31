/**
 * 
 */
(function() {
	'use strict';

	angular
	.module('plunker')
	.service('dataService', dataServiceFn);

	dataServiceFn.$inject = ['$q', '$http'];

	function dataServiceFn($q, $http) {
		var self = this;

		self.assignTable = function(reservation){
			var defer = $q.defer();
			
//			$http({
//				method: 'POST',
//				url: '/RestaurantMS/api/reservation/assignTable',
//				data: reservation
//			}).success(function(){
//				console.log("Data in response: " + data.payload);
//				defer.resolve(data);
//			})
//			.error(function(err) {
//				defer.reject(err);
//			});
			
			
			$http.post('/RestaurantMS/api/reservation/addReservation', reservationObj)
			.success(function(data) {
				console.log("Data in response: " + data.payload);
				defer.resolve(data);
			})
			.error(function(err) {
				defer.reject(err);
			});
			
		}
		
		
		self.getReserv = function() {
			var defer = $q.defer();

			$http({
				method: 'GET',
				url: '/api/user/getAll'
			})
			.success(function(data) {
				defer.resolve(data);
			})
			.error(function(err) {
				defer.reject(err);
			});

			return defer.promise;
		};


		self.updateRestaurantDetails = function(restObj) {
			var defer = $q.defer();

			$http({
				method: 'POST',
				url: '/RestaurantMS/api/reservation/owner/updateRestaurant',
				data: restObj
			})
				.success(function(data) {
					defer.resolve(data);
				})
				.error(function(err) {
					defer.reject(err);
				});

			return defer.promise;
		};

		self.getRestDetails = function(restID) {
			var defer = $q.defer();

			$http({
				method: 'GET',
				url: '/RestaurantMS/api/reservation/getRestaurant/'+restID
			})
				.success(function(data) {
					defer.resolve(data);
				})
				.error(function(err) {
					defer.reject(err);
				});

			return defer.promise;
		};


		self.updateReserv = function(reservationObj) {
			var defer = $q.defer();

			$http({
				method: 'POST',
				url: '/RestaurantMS/api/reservation/owner/updateReservation',
				data: reservationObj
			})
			.success(function(data) {
				defer.resolve(data);
			})
			.error(function(err) {
				defer.reject(err);
			});

			return defer.promise;
		};

		self.getAllReserv = function() {
			var defer = $q.defer();

			$http({
				method: 'GET',
				url: '/RestaurantMS/api/reservation/getAll'
			})
				.success(function(data) {
					defer.resolve(data);
				})
				.error(function(err) {
					defer.reject(err);
				});

			return defer.promise;
		};

		self.getStatus = function(confirmNumb) {
			var defer = $q.defer();

			$http({
				method: 'GET',
				url: '/RestaurantMS/api/reservation/get/'+confirmNumb
			})
			.success(function(data) {
				defer.resolve(data);
			})
			.error(function(err) {
				defer.reject(err);
			});

			return defer.promise;
		};



		self.deleteReserv= function(confirmNumb) {
			var defer = $q.defer();

			$http({
				method: 'GET',
				url: '/RestaurantMS/api/reservation/deleteReservation/'+confirmNumb
			})
				.success(function(data) {
					defer.resolve(data);
				})
				.error(function(err) {
					defer.reject(err);
				});

			return defer.promise;
		};


		self.makeReservation = function(reservationObj) {


//			var dataObj = {
//					name : $scope.name,
//					employees : $scope.employees,
//					headoffice : $scope.headoffice
//			};	
//			var res = $http.post('/RestaurantMS/api/reservation/addReservation', reservationObj);
//			res.success(function(data, status, headers, config) {
//				console.log("Data in response: " + data.payload);
//				$scope.newInsertedReservation = data.payload;
//				defer.resolve(data);
//			});
//			res.error(function(data, status, headers, config) {
//				alert( "failure message: " + JSON.stringify({data: data}));
//			});

			var defer = $q.defer();

			$http.post('/RestaurantMS/api/reservation/addReservation', reservationObj)
			.success(function(data) {
				console.log("Data in response: " + data.payload);
				defer.resolve(data);
			})
			.error(function(err) {
				defer.reject(err);
			});

			return defer.promise;
		};

		self.title = 'not defined yet';

	}
	self.getInfo = function(confirmNumb) {
		var defer = $q.defer();

		$http({
			method: 'GET',
			url: '/RestaurantMS/api/reservation/get/'+confirmNumb
		})
			.success(function(data) {
				defer.resolve(data);
			})
			.error(function(err) {
				defer.reject(err);
			});

		return defer.promise;
	};


})();