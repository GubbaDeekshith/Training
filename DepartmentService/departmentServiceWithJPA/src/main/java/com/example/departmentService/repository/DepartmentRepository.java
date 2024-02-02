package com.example.departmentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.departmentService.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}