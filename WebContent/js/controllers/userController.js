angular.module("morpheus").controller("userController",function($scope,userService){

	$scope.users = userService.userList();

	$scope.userInsert = function(user){
		if(userService.userInsert(user)){
			$scope.users.push({name: user.name});
		}
		$scope.user.name = null;
	};
	
});	