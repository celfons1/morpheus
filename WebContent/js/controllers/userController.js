angular.module("morpheus").controller("userController",function($scope, Upload){

	$scope.users = [];
     
     $scope.submit = function(file) {
         if (file != null) {
        	 $scope.uploadFile(file);
         }
       };

       $scope.uploadFile = function (file) {
           Upload.upload({
        	   method: 'POST',
               url: 'http://localhost:8080/morpheus/rest/post', 
               data:  file,
               headers: {'Access-Control-Allow-Origin': '*'}
           }).then(function (resp) {
          	 $scope.users.push({name:resp.data.name});
           });
       }
	
});	