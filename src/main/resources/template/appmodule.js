var app = angular.module('dish-app', []);

app.controller('controller', function($scope, $http){
	url = '';
	$scope.findId = function(id){
		$scope.dishId = id;
		$scope.url = 'http://localhost:9090/dish/find/id/' + $scope.dishId;
		$http.get($scope.url).
		then(function(response){
			$scope.dish = response.data;
		});
	}
	
	
	$scope.upload = function(file){
	    var fd = new FormData();
	    uploadUrl = 'http://localhost:9090/upload'
	    fd.append('file', file);
	    id = 3;
	    $http.post(uploadUrl, fd, id)
	    .success(function(){
	    })
	    .error(function(){
	    });
	  }
	
});