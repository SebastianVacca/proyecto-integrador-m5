package com.devsenior.svacca.proyecto_integrador_m5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class openApiConfiguration {
    
    @Bean
    OpenAPI openApi(){
        return new OpenAPI()
            .info(new Info()
                .title("API para un sistema simplificado de gestión de Biblioteca")
                .description("API desarrollado con fines educativo que emula el sistema de gestión de libros para una biblioteca")
                .version("v1.0")
            .contact(new Contact()
                .name("Juan Sebastian Vacca Peña")
                .email("clanbs11.12@gmail.com"))
            .license(new License()
                .name("MIT License")
                .url("https://opensource.org/license/MIT")
            ));
        }
}   
