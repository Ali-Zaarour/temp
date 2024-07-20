package dev.alizaarour.demo.configuration;

import dev.alizaarour.demo.exception.config.ExceptionMessage;
import dev.alizaarour.demo.utils.JWTOnePerRequestFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * <p>For more information about this topic visit spring documentation.</p>
 * <p>
 * 1. <a href="https://docs.spring.io/spring-security/reference/index.html">Spring security</a>
 */


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityFilter {

    private static final String[] WHITE_LIST_URL = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/unsecured/**"
    };

    private final JWTOnePerRequestFilter jwtOnePerRequestFilter;
    private final AuthenticationProvider authenticationProvider;

    @Autowired
    public SecurityFilter(JWTOnePerRequestFilter jwtOnePerRequestFilter, AuthenticationProvider authenticationProvider) {
        this.jwtOnePerRequestFilter = jwtOnePerRequestFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests ->
                        requests.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(this.authenticationProvider)
                .addFilterBefore(jwtOnePerRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exHd -> exHd.authenticationEntryPoint(
                        // Rejecting request as unauthorized when entry point is reached
                        // If this point is reached it means that the current request requires authentication
                        // and no JWT token was found attached to the Authorization header of the current request.
                        (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ExceptionMessage.UNAUTHORIZED_ACTION)));
        return httpSecurity.build();
    }
}
