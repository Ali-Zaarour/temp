package dev.alizaarour.demo.services;


import dev.alizaarour.demo.payload.LoginRequest;

import java.util.Map;
import java.util.Optional;

public interface AuthenticationService {
    Optional<Map<String, Object>> login(LoginRequest loginRequest);
}
