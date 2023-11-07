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
import com.github.cleyto_orocha.library_system.services.security.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> findAll() {
        return usersService.listAll();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AccountCredentialsVO accountCredentialsVO){
        return usersService.login(accountCredentialsVO);
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register (@RequestBody @Valid RegisterDTO data){
        return usersService.register(data);
    }

    
}
