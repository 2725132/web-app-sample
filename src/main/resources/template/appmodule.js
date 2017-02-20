var app = angular.module('dish-app', []);
app.controller('controller', function($scope, $http){
	url = '';
	$scope.findId = function(id){
		$scope.dishId = id;
		$scope.url = 'http://localhost:9090/dish/' + $scope.dishId + '/json';
		$http.get($scope.url).
		then(function(response){
			$scope.dish = response.data;
		});
	}
	
	
});