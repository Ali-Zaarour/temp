package dev.alizaarour.demo.services;

import dev.alizaarour.demo.dto.AppUserDTO;
import dev.alizaarour.demo.exception.config.ExceptionMessage;
import dev.alizaarour.demo.payload.LoginRequest;
import dev.alizaarour.demo.repositories.AppUserRepository;
import dev.alizaarour.demo.utils.Constants;
import dev.alizaarour.demo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AppUserRepository appUserRepository;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationServiceImpl(AppUserRepository appUserRepository, JWTUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.appUserRepository = appUserRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Optional<Map<String, Object>> login(LoginRequest loginRequest) {
        // validate the provided user detail
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        // retrieve client meta-date
        var appUser = appUserRepository.findByUsername(loginRequest.getUsername());
        if (appUser.isPresent()) {
            if (!appUser.get().isEnabled()) throw new DisabledException(ExceptionMessage.USER_DISABLED);
            //generate token
            String token = jwtUtil.generateJWTToken(appUser.get());
            //create return value
            return Optional.of(
                    new HashMap<String, Object>() {{
                        put(Constants.APP_USER_DTO, AppUserDTO.builder().id(appUser.get().getId()).username(appUser.get().getUsername()).build());
                        put(Constants.SECURITY_ATTRIBUTE_TOKEN,token);
                    }}
            );
        }
        return Optional.empty();
    }
}
