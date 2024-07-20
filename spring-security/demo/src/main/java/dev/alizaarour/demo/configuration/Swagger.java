package dev.alizaarour.demo.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "spring-security-demo",
                        email = "example.outlook.com",
                        url = "https://example-url"
                ),
                description = "OpenApi specification for spring security",
                title = "Swagger doc",
                version = "1.0"
        ),
        servers = {
                @Server(description = "Local Env", url = "http://localhost:4100/demo/spring-security"),
                @Server(description = "Prod Env", url = "https://prod-ex.com")
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "Json web token",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class Swagger {
}
