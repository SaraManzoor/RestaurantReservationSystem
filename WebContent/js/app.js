/**
 *
 */
(function(){
    'use strict';

    angular
        .module('plunker', ['ngRoute', 'ngMessages'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];
    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/reserv', {
                templateUrl: 'templates/reserv-tmpl.html',
                controller: 'reservCtrl',
                controllerAs: 'reservVm'
            })
//        .when('/home', {
//          templateUrl: 'templates/home.html'
//        })
//        .when('/', {
//          templateUrl: 'templates/reserv-tmpl.html',
//          controller: 'reservCtrl',
//          controllerAs: 'reservVm'
//        })
            .when('/make_reservation', {
                templateUrl: 'templates/make-reserv-tmpl.html',
                controller: 'makeReservCtrl',
                controllerAs: 'makeReserVm'
            })
            .when('/check_status', {
                templateUrl: 'templates/check-status.html',
                controller: 'checkStatusCtrl',
                controllerAs: 'checkStatusVm'
            })
            .when('/owner-login', {
                templateUrl: 'templates/owner-login.html',
                controller: 'ownerLoginCtrl',
                controllerAs: 'ownerLoginVm'
            })
            .when('/view-reservation', {
                templateUrl: 'templates/owner/owner-show-reserv.html',
                controller: 'ownerCtrl',
                controllerAs: 'ownerVm'
            })
            .when('/userReservation/:confirmationNum', {
                templateUrl: 'templates/owner/customer-profile.html',
                controller: 'custProfileCtrl',
                controllerAs: 'custProfileCtrl'
            })
            .when('/view-seating', {
                templateUrl: 'templates/owner/owner-seating-area.html'
            })
            .when('/new-reservation', {
                templateUrl: 'templates/owner/owner-new-reserv.html'
            })
            .when('/contact_form', {
                templateUrl: 'templates/Contact-html.html'
            })
            .when('/owner/assign-table/:confirmationNumberSara', {
                templateUrl: 'templates/owner/assign-table.html',
                controller: 'ownerAssignTableCtrl',
                controllerAs: 'ownerAssignTableVm'
            })
            .when('/customer_edit/:confirmationNum', {
                templateUrl: 'templates/customer-edit-reserv.html',
                controller: 'customerEditCtrl',
                controllerAs: 'customerEditVm'
            })
            .when('/owner/edit-rest-profile/:restID', {
                templateUrl: 'templates/owner/owner-rest-profile.html',
                controller: 'restProfileCtrl',
                controllerAs: 'restProfileVm'
            })
//        .when('/reserv/:reservid', {
//          templateUrl: 'reserv-profile-tmpl.html',
//          controller: 'reservProfileCtrl',
//          controllerAs: 'reservprofileVm'
//        })
//        .when('/restaurant', {
//          templateUrl: 'restaurant-tmpl.html',
//          controller: 'restaurantCtrl',
//          controllerAs: 'restaurantVm'
//        })
            .otherwise({
                redirectTo: '/make_reservation'
            });
    }


//    $('#checkStatus').click(function(){
//		$.ajax({
//			url: 'api/user/get',
//			type: 'GET',
//			error: function(error){
//				console.log(error);
//			},
//			success: function(data){
//				console.log(data);
//			}
//		})
//	});

})();
