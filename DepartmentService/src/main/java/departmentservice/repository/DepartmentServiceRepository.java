package departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import departmentservice.entity.DepartmentServiceEntity;

public interface DepartmentServiceRepository extends JpaRepository<DepartmentServiceEntity, Integer> {

}
