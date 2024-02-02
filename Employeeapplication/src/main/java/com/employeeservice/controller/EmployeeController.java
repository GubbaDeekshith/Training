package com.employeeservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.dto.Employee;
import com.employeeservice.entity.EmployeeEntity;
import com.employeeservice.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping("/employees")
public class EmployeeController {
	List<Employee> emplist = new ArrayList<Employee>();
	
	//Get all employees
	@Autowired
	EmployeeService empser;
	@GetMapping
	
	public List<Employee> getAllEmployees(){
		return empser.getAllEmployees();

	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		return empser.getEmployeeById(id);
	}
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee createEmployee){
		return empser.createEmployee(createEmployee);
	}
	
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee updateEmployee) {
		return empser.updateEmployee(id,updateEmployee);
		}
	
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		empser.deleteEmployeeById(id);
		return "Deleted employee with employee id: "+id;
	}
	
	@DeleteMapping
	public String deleteAll() {
		empser.deleteAll();
		return "Deleted all the employees!!";
	}
	
	

	@GetMapping("/emp")
	public List<EmployeeEntity> getEmployeeByFirstNameAndPosition(@RequestParam String firstName, @RequestParam String position){
		return empser.findEmployeeByFirstNameAndPosition(firstName, position);
	}
	
	@CircuitBreaker(name = "CB", fallbackMethod = "fallBack")
	@GetMapping("/department/{id}")
	public String getName(@PathVariable int id) {
		return empser.getName(id);
	}
	
	
	//Fallback method
	@CircuitBreaker(name = "CB", fallbackMethod = "fallBack")
	@GetMapping("/department/service/{id}")
	public String getNamebydiscovery(@PathVariable int id) {
		return empser.getNamebydiscovery(id);
	}
	

	public String fallBack(Throwable t) {
		return "Application is facing issues please try after some time";
	}
}
