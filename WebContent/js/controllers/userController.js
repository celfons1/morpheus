angular.module("morpheus").controller("userController",function($scope,userService){

	$scope.users = [{
		name:null
	}];

	$scope.userList = function(){
		$scope.users = userService.userList();
	};

	$scope.userInsert = function(user){
		if(userService.userInsert(user)){
			$scope.users.push({name: user.name});
		}
	};
	
});	