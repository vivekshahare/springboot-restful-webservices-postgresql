package com.practice.springboot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
        title = "Spring Boot Rest API documentation",
        description = "Spring Boot Rest API documentation",
        version = "v1.0",
        contact = @Contact(
                name = "Vivek",
                email = "support@test.com")
))
public class SpringBootRestfulWebservicesPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestfulWebservicesPostgresqlApplication.class, args);
    }

}
