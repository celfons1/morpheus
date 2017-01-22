angular.module("morpheus").service('userService', function($http) {

	this.userList = function(){
		return  $http({
			 	method: 'GET',
	            url: 'http://localhost:8080/morpheus/rest/get', 
	            headers: {'Access-Control-Allow-Origin': '*'}
		});
	};

	this.userInsert = function(user){
		$http.post("http://localhost:8080/morpheus/rest/post",user).success(function(){
			return true;
		}).error(function(){
			return false;	
		});
	};

});		