angular.module("morpheus").service('userService', function($http) {

	this.uploadFile = function(file){
		var fd = new FormData();
		fd.append('data', angular.toJson(file));
		console.log(file);/*
        $http({
        	method: 'POST',
            url: 'http://localhost:8080/morpheus/rest/post', 
            data: fd,
            headers: {'Access-Control-Allow-Origin': '*'}
        }).success(function(data){
        	console.log("ok");
        }).error(function(){
        	console.log("fail");
        });*/
     }

});		