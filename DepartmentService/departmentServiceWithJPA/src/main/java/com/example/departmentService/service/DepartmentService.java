package com.example.departmentService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentService.dto.Department;
import com.example.departmentService.entity.DepartmentEntity;
import com.example.departmentService.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAllDepartment() {
		List<DepartmentEntity> depEntityList = departmentRepository.findAll();
		List<Department> depList = new ArrayList<>();
		for (DepartmentEntity dep : depEntityList) {
			depList.add(new Department(dep.getDepartmentId(), dep.getDepartmentName()));
		}
		return depList;
	}

	public String getDepartmentById(int id) {
		DepartmentEntity dep = departmentRepository.findById(id).orElse(null);
		if (dep != null) {
			return dep.getDepartmentName();
		}

		return null;
	}

	public Department createDepartment(Department dep) {
		DepartmentEntity depEntity = new DepartmentEntity(dep.getDepartmentId(), dep.getDepartmentName());
		DepartmentEntity depEntity1 = departmentRepository.save(depEntity);
		return new Department(depEntity1.getDepartmentId(), depEntity1.getDepartmentName());

	}

	public Department updateDepartment(int id, Department updatedDepartment) {
		DepartmentEntity existingdepartment = departmentRepository.findById(id).orElse(null);
		if (existingdepartment != null) {
			existingdepartment.setDepartmentName(updatedDepartment.getDepartmentName());
			DepartmentEntity depEntity1 = departmentRepository.save(existingdepartment);
			return new Department(depEntity1.getDepartmentId(), depEntity1.getDepartmentName());
		}
		return null;
	}
}
