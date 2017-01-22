angular.module("morpheus").controller("userController",function($scope,userService){

	$scope.users = [];

	$scope.userList = function(){
		userService.userList().then(function(response) {
			console.log(response.data.name);
			$scope.users.push({name: response.data.name});
		});
	};

	$scope.userInsert = function(user){
		userService.userInsert(user);
		$scope.users.push({name: user.name});
	};
	
});	