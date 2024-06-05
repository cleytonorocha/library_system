package com.github.cleyto_orocha.library_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@OpenAPIDefinition
@io.swagger.v3.oas.annotations.security.SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT", in = SecuritySchemeIn.HEADER)
public class Swagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()

                .info(new Info()

                        .title("Library System")
                        .version("1.0")
                        .description(
                                "O intuito para desenvolver essa aplicação é espelhar uma grande livraria que pode conter diversos produtos no qual estão interligados em uma tabela única."))

                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("Authorization")
                                        .description("Token JWT")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .in(SecurityScheme.In.HEADER)));
    }
}