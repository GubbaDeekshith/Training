package departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Department Service Api"))
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DepartmentServiceApplication.class, args);
		
	}

}
