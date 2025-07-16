package com.sdb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Course Management API")
                        .version("1.0")
                        .description("API documentation for Student Course Management System")
                        .contact(new Contact().email("gaurav@gmail.com").name("Gaurav").url("abc@gmail.com")));
    }

}
