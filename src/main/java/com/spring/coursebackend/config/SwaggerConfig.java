package com.spring.coursebackend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Course Backend API",
                version = "api/v1",
                description = "API documentation for Course Backend application",
                summary = "API documentation for Course Backend application",
                contact = @Contact(
                        name = "Course Backend",
                        email = "abhishekritu810219@gmail.com",
                        url = "xyz.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                ),
                termsOfService = "http://swagger.io/terms/"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "prod"
                ),
                @Server(
                        url = "http://localhost:8081",
                        description = "dev"
                ),
                @Server(
                        url = "http://localhost:8082",
                        description = "test"
                )
        },
        externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(
                description = "Find out more about Swagger",
                url = "http://swagger.io"
        ),
        security = @SecurityRequirement(name = "basic")
)


@SecurityScheme(
        name = "basic",
        in = SecuritySchemeIn.HEADER,   // can be omitted as default value is HEADER
        type = SecuritySchemeType.HTTP,
        scheme = "basic",
        bearerFormat = "JWT",
        description = "Basic Auth"
)





@Configuration
public class SwaggerConfig {
    // This method is not needed if the OpenAPIDefinition annotation is correctly used.
    // Uncomment and adjust if additional custom OpenAPI configurations are required.
    // @Bean
    // public OpenAPI customOpenAPI() {
    //     return new OpenAPI()
    //             .info(new io.swagger.v3.oas.models.info.Info()
    //                     .title("Course Backend API")
    //                     .version("1.0.0")
    //                     .description("API documentation for Course Backend application"));
    // }
}
