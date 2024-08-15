package com.github.cleyto_orocha.library_system.controllers.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.controllers.dto.RegisterDTO;
import com.github.cleyto_orocha.library_system.entities.Users;
import com.github.cleyto_orocha.library_system.enums.SwaggerEnum;
import com.github.cleyto_orocha.library_system.services.security.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Tag(name = SwaggerEnum.USER_TAG_NAME, description = SwaggerEnum.USER_TAG_DESCRIPTION)
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        List<Users> users = usersService.listAll();
        return ResponseEntity.ok().body(users);
    }

    @Operation(
        summary = "Register a new user",
        description = "Registers a new user and returns a jwt confirmation token. You don't need to copy, log in using the login method.", 
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "User register",
            content = @Content(
                schema = @Schema(implementation = Users.class)
            )
        )
    )
    
    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register(@RequestBody @Valid RegisterDTO data) {
        ResponseEntity<LoginResponseDTO> response = usersService.register(data);
        return response;
    }
    @Operation(
        summary = "Login a registered user",
        description = "Copy the token that returned from the method and paste it into the padlock next to any Swagger method. This way you will be able to log into the application.", 
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "User Login",
            content = @Content(
                schema = @Schema(implementation = RegisterDTO.class)
            )
        )
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AccountCredentialsVO accountCredentialsVO) {
        return usersService.login(accountCredentialsVO);
    }
    
}
