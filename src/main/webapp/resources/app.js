/**
 * Created by Admin on 02.09.2017.
 */
var gabinet = angular.module("gabinetApp", []);
gabinet.controller('GabinetCtrl', function ($scope, $http) {
    $scope.hello = 'This is angular post method example!';
    var self = this;
    self.submitForm = function () {
        var data = {
            coursename: $scope.coursename,
            duration: $scope.duration,
            cost: $scope.cost,
            description: $scope.description
        };
        $http.post('/addCources', data).then(function (responce) {
            if(responce.success){
                alert('Ok')
            }else {
                alert('Error')
            }
        })
    }


});