package com.example.departmentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentService.dto.Department;
import com.example.departmentService.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public String getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable int id, @RequestBody Department updatedDepartment) {
    	return departmentService.updateDepartment(id,updatedDepartment);
    }
}
