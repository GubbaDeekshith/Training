package com.employeeservice.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.employeeservice.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.position = :position")
    List<EmployeeEntity> findEmployeesByFirstNameAndPosition(String firstName, String position);

}
