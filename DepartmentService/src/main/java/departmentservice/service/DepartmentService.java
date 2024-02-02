package departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import departmentservice.dto.Department;
import departmentservice.entity.DepartmentServiceEntity;
import departmentservice.repository.DepartmentServiceRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentServiceRepository depRepo;
	
	
	public Department getDepartmentById(int id) {
		DepartmentServiceEntity dep = depRepo.findById(id).orElse(null);
		if(dep != null) {
			Department d = new Department(dep.getDepartmentId(), dep.getDepartmentName());
			return d;
		}
		return null;
		
	}
	
	
	
	public Department createDepartment(Department createDepartment) {
		// TODO Auto-generated method stub
		DepartmentServiceEntity dept=new DepartmentServiceEntity(createDepartment.getDepartmentId(),createDepartment.getDepartmentName());
		DepartmentServiceEntity deptEntity1=depRepo.save(dept);
			return new Department(deptEntity1.getDepartmentId(),deptEntity1.getDepartmentName());
}
	
	public Department updateDepartment(int id, Department updateDepartment) {
		// TODO Auto-generated method stub
		DepartmentServiceEntity existDept= depRepo.findById(id).orElse(null);
		if(existDept !=null) {
			existDept.setDepartmentId(updateDepartment.getDepartmentId());
			existDept.setDepartmentName(updateDepartment.getDepartmentName());
			DepartmentServiceEntity deptEntity= depRepo.save(existDept);
			return new Department(deptEntity.getDepartmentId(),deptEntity.getDepartmentName());
		}
		return null;
	}

}
