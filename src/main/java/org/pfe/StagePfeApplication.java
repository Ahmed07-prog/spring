package org.pfe;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Constat API", version = "1.0", description = "Documentation Constat API v1.0"))
public class StagePfeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StagePfeApplication.class, args);
	}

}
