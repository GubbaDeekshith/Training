package com.employeeservice.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employeeservice.dto.Employee;
import com.employeeservice.entity.EmployeeEntity;
import com.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	RestTemplate restTemp;
	
	public List<Employee> getAllEmployees(){
		List<EmployeeEntity> list = empRepo.findAll();
		List<Employee> returnList = new ArrayList<>();
		for(EmployeeEntity e : list) {
			returnList.add(new Employee(e.getEmployeeId(),e.getFirstName(),
					e.getLastName(),e.getEmail(),e.getDepartmentId(),
					e.getPosition(),e.getPhonenumber()));
		}
		return returnList;
	}
	
	public Employee getEmployeeById(int id) {
		EmployeeEntity emp = empRepo.findById(id).orElse(null);
		if(emp != null) {
			Employee e = new Employee(emp.getEmployeeId(), emp.getFirstName(), emp.getLastName(),emp.getEmail(), emp.getDepartmentId(), emp.getPosition(), emp.getPhonenumber());
			return e;
		}
		return null;
	}
	
	
	//Create employee
	public Employee createEmployee(Employee emp) {
		EmployeeEntity empEntity = new EmployeeEntity(emp.getEmployeeId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getDepartmentId(), emp.getPosition(), emp.getPhonenumber());
		EmployeeEntity empEntity1 = empRepo.save(empEntity);
		return new Employee(empEntity1.getEmployeeId(), empEntity1.getFirstName(), empEntity1.getLastName(), empEntity1.getEmail(), empEntity1.getDepartmentId(), empEntity1.getPosition(), empEntity1.getPhonenumber());
	}
	
	
	
	//Update

	public Employee updateEmployee(int id, Employee updateEmployee) {
			
		EmployeeEntity existEmp= empRepo.findById(id).orElse(null);
		if(existEmp !=null) {
			existEmp.setFirstName(updateEmployee.getFirstName());
			existEmp.setPosition(updateEmployee.getPosition());
			EmployeeEntity empEntity= empRepo.save(existEmp);
			return new Employee(empEntity.getEmployeeId(), empEntity.getFirstName(), empEntity.getLastName(), empEntity.getEmail(), empEntity.getDepartmentId(), empEntity.getPosition(), empEntity.getPhonenumber());

			}

		return null;

		}
	
	
	//Delete employee by ID
	public void deleteEmployeeById(int id) {
		empRepo.deleteById(id);
	}
	
	
	//Delete all
	public void deleteAll() {
		empRepo.deleteAll();
	}
	
	//Update using firstname and position
	public List<EmployeeEntity> findEmployeeByFirstNameAndPosition(String firstName, String position){
		return empRepo.findEmployeesByFirstNameAndPosition(firstName, position);
	}

	//Using Resttemplate
	public String getName(int id) {
		// TODO Auto-generated method stub
		EmployeeEntity emp = empRepo.findById(id).orElse(null);
		if(emp!=null) {
			int dep = emp.getDepartmentId();
			String result = restTemp.getForObject("http://localhost:8080/department/{id}", String.class, dep);
			return result;
		}
		
		return null;
	}
	
	
	//using ServiceDiscovery
	public String getNamebydiscovery(int id) {
		// TODO Auto-generated method stub
		EmployeeEntity emp = empRepo.findById(id).orElse(null);
		if(emp!=null) {
			int dep = emp.getDepartmentId();
			String result = restTemp.getForObject("http://DepartmentService/department/{id}", String.class, dep);
			return result;
		}
		
		return null;
	}
}
