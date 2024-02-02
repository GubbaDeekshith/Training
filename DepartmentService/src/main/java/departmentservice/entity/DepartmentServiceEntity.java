package departmentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DepartmentServiceEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public DepartmentServiceEntity(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	public DepartmentServiceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
