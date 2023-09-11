package com.github.cleyto_orocha.library_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.controllers.dto.AuthenticationDTO;
import com.github.cleyto_orocha.library_system.controllers.dto.RegisterDTO;
import com.github.cleyto_orocha.library_system.entities.Users;
import com.github.cleyto_orocha.library_system.services.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public void login(@RequestBody @Valid AuthenticationDTO data){
        usersService.login(data);
    }

    @PostMapping("/register")
    public ResponseEntity<Users> register (@RequestBody @Valid RegisterDTO data){
        return usersService.register(data);
    }
}
