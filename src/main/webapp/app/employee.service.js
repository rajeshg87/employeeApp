'use strict';

angular.module('employeeApp').factory('EmployeeService', ['$http', '$q', function($http, $q){

    var factory = {
    		fetchAllEmployee: fetchAllEmployee,
    		createEmployee: createEmployee,
    		deleteEmployee: deleteEmployee
    };

    return factory;
    
    function fetchAllEmployee() {
    	var url = "http://localhost:8081/EmployeeApp/rest/employee/listAllEmployee";
        var deferred = $q.defer();
        $http.get(url)
            .then(
            function (response) {
            	console.log('Employee Fetch Successful');
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function createEmployee(employee) {
        var deferred = $q.defer();
        console.log('Name :', employee.name); 
        console.log('Desg :', employee.desg);
        var url = "http://localhost:8081/EmployeeApp/rest/employee/createEmployee";
        $http.post(url, employee)
            .then(
            function (response) {
            	console.log('Success');
            	deferred.resolve(response.data);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function deleteEmployee(id) {
        var deferred = $q.defer();
        var url = "http://localhost:8081/EmployeeApp/rest/employee/deleteEmployee/";
        $http.delete(url+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    

}]);
