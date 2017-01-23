angular.module("morpheus").controller("userController",function($scope, Upload){

	$scope.users = [];
	
	$scope.userInsert = function(user){
		$scope.users.push({name : user.name});
	}
     
     $scope.submit = function(file) {
         if (file != null) {
        	 $scope.uploadFile(file);
         }
       };

       $scope.uploadFile = function (file) {
           Upload.upload({
        	   method: 'POST',
               url: 'http://localhost:8080/morpheus/rest/post', 
               file:  file,
               headers: {'Access-Control-Allow-Origin': '*'}
           }).then(function (resp) {
        	   for(var i=0; i<resp.data.length; i++) {
            	   console.log(resp.data[i].name);
        		    $scope.users.push({
        		        name: resp.data[i].name
        		    });
        		}
           });
       }
	
});	