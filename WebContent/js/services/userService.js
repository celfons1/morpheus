angular.module("morpheus").service('userService', function($http) {

	this.userList = function(){
		$http({
			 	method: 'GET',
	            url: 'http://localhost:8080/morpheus/get', 
	            headers: {'Access-Control-Allow-Origin': '*'}
		}).success(function(data){
			return data;
		}).error(function(data,status){
			return alert("Erro na conexão, tente novamente!");
		});
	};

	this.userInsert = function(user){
		$http.post("http://localhost:8080/morpheus/post",user).success(function(){
			return true;
		}).error(function(){
			return false;	
		});
	};

});		