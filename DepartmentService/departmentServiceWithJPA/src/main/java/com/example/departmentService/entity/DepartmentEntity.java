package com.example.departmentService.entity;

import jakarta.persistence.*;

@Entity
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    private String departmentName;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public DepartmentEntity(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	public DepartmentEntity() {
		// TODO Auto-generated constructor stub
	}
    
	
}
