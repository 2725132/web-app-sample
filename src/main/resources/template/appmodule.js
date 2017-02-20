var app = angular.module('dish-app', []);
app.controller('controller', function($scope, $http){
	$http.get('http://localhost:9090/dish/2/json').
	then(function(response){
		$scope.dish = response.data;
	});
});