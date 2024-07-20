package dev.alizaarour.demo.services;

import dev.alizaarour.demo.dto.AppUserDTO;
import dev.alizaarour.demo.payload.CreateUserRequest;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<AppUserDTO> createUser(CreateUserRequest createUserRequest, UUID principalId);
}
