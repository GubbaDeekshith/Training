package departmentservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import departmentservice.dto.Department;
import departmentservice.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentServiceController {
	
	List<Department> deplist = new ArrayList<Department>();
	
	@Autowired
	DepartmentService depser;
	
	@GetMapping("/byid/{id}")
	public Department getDepartmentById(@PathVariable int id){
		return depser.getDepartmentById(id);
	}
	
	
	@PostMapping("/create")
	public Department createDepartment(@RequestBody Department createDepartment){
		return depser.createDepartment(createDepartment);
	}
	
	
	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable int id,@RequestBody Department updateDepartment) {
		return depser.updateDepartment(id,updateDepartment);}
	
	@GetMapping("/{id}")
	public String getName(@PathVariable int id) {
		return depser.getDepartmentById(id).getDepartmentName();
	}
	

}
