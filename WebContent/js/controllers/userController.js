angular.module("morpheus").controller("userController",function($scope,$http, Upload){

	$scope.users = [];
	
	$scope.userInsert = function(user){
		$http({
     	   method: 'POST',
            url: 'http://localhost:8080/morpheus/rest/insert', 
            data:  user.name,
            headers: {'Access-Control-Allow-Origin': '*'}
        }).then(function (response) {
        	$scope.users.push({name : user.name});
        });
	}
	
	$scope.userList = function(user){
		window.location.href = "http://localhost:8080/morpheus/rest/download" ;
	}
     
     $scope.submit = function(file) {
         if (file != null) {
        	 $scope.uploadFile(file);
         }
       };

       $scope.uploadFile = function (file) {
           Upload.upload({
        	   method: 'POST',
               url: 'http://localhost:8080/morpheus/rest/attachment', 
               file:  file,
               headers: {'Access-Control-Allow-Origin': '*'}
           }).then(function (resp) {
        	   for(var i=0; i<resp.data.length; i++) {
        		    $scope.users.push({
        		        name: resp.data[i].name
        		    });
        		}
           });
       }
	
});	