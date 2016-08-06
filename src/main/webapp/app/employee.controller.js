'use strict';

angular.module('employeeApp').controller('employeeController', ['$scope','EmployeeService', function($scope, EmployeeService) {
    
	var self = this;
	self.employee={name:'',desg:''};
	self.employees=[];
	self.submit = submit;
    self.reset = reset;
    self.remove = remove;
    self.edit = edit;
	
    fetchAllEmployee();
    
    
    function fetchAllEmployee(){
    	EmployeeService.fetchAllEmployee()
            .then(
            function(d) {
            	console.log('Emplyee Fetch Successful');
                self.employees = d;
            },
            function(errResponse){
                console.error('Error while fetching Employee');
            }
        );
    }    
    
    function createEmployee(employee){
        EmployeeService.createEmployee(employee)
            .then(
            	fetchAllEmployee,
            function(errResponse){
                console.error('Error while creating Employee');
            }
        );
    }
    
    function deleteEmployee(id){
        EmployeeService.deleteEmployee(id)
            .then(
            		fetchAllEmployee,
            function(errResponse){
                console.error('Error while deleting Employee');
            }
        );
    }
    
    function submit(val) {        
       createEmployee(self.employee);
    }
    
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.employees.length; i++){
            if(self.employees[i].id == id) {
                self.employee = angular.copy(self.employees[i]);
                break;
            }
        }
    }

    
    function remove(val){
        console.log('id to be deleted', +val);
        deleteEmployee(val);
    }
    
    function reset(val){
    	console.log('FORM RESET SUCCESSFULLY '+val);
        self.employee={name:'',desg:''};
        $scope.myForm.$setPristine(); //reset Form
    }


}]);
