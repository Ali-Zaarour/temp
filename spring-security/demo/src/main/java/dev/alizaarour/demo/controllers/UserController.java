package dev.alizaarour.demo.controllers;

import dev.alizaarour.demo.dto.AppUserDTO;
import dev.alizaarour.demo.entity.AppUser;
import dev.alizaarour.demo.exception.config.ErrorStruct;
import dev.alizaarour.demo.exception.config.ExceptionMessage;
import dev.alizaarour.demo.payload.CreateUserRequest;
import dev.alizaarour.demo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "User api")
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            description = "This endpoint is provided to create a new client",
            summary = "create new user",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = AppUserDTO.class))),
                    @ApiResponse(
                            description = "Conflict",
                            responseCode = "409",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorStruct.class))),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorStruct.class))),
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateUserRequest.class)))
    )
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') &&  hasAuthority('permission:create')")
    public ResponseEntity<AppUserDTO> createUser(@Valid @RequestBody CreateUserRequest createUserRequest, @AuthenticationPrincipal @NonNull AppUser principalDetails) {
        var createdUser = userService.createUser(createUserRequest, principalDetails.getId());
        return createdUser.map(ResponseEntity::ok).orElseThrow(() -> new DataIntegrityViolationException(ExceptionMessage.DATA_INTEGRITY_VIOLATION));
    }
}
