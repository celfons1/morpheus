angular.module("morpheus").config(function($routeProvider){
	$routeProvider.when("/view",{
		templateUrl:"view/view.html",
		controller:'userController'
	});
});