angular.module("morpheus").service('userService', function($http) {

	this.userList = function(){
		$http.get("http://localhost:8080/morpheus/users/get").success(function(data){
			return data;
		}).error(function(){
			return alert("Erro na conexão, tente novamente!");	
		});
	};

	this.userInsert = function(user){
		$http.post("http://localhost:8080/morpheus/users/post",user).success(function(){
			return true;
		}).error(function(){
			return false;	
		});
	};

});		