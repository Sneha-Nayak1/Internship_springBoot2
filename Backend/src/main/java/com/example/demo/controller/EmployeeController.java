package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
		private EmployeeService employeeService;

		public EmployeeController(EmployeeService employeeService) {
			super();
			this.employeeService = employeeService;
		}
		
		//create employee data
		@PostMapping
		public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
			
			return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		}
		
		//get all data
		@GetMapping
		
		public List<Employee> getAllEmployees(){
			return employeeService.getAllEmployee();
		}
		
		//getById
		@GetMapping("{id}")
		public  ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
			return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
		}
		
		@PutMapping("{id}")
		public ResponseEntity<Employee> updateEmployee( @RequestBody Employee employee,@PathVariable long id ){
			return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
		}
		
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
			employeeService.deleteEmployee(id);
			return new ResponseEntity<String>("Employee deleted succsessfully!", HttpStatus.OK);
			
		}
}
