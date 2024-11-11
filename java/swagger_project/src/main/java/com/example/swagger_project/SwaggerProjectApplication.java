package com.example.swagger_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerProjectApplication.class, args);
	}

}
