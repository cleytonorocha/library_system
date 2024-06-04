package com.github.cleyto_orocha.library_system.services.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.controllers.dto.RegisterDTO;
import com.github.cleyto_orocha.library_system.controllers.security.AccountCredentialsVO;
import com.github.cleyto_orocha.library_system.controllers.security.LoginResponseDTO;
import com.github.cleyto_orocha.library_system.entities.Users;
import com.github.cleyto_orocha.library_system.repositories.UsersRepository;
import com.github.cleyto_orocha.library_system.security.JwtService;

import io.swagger.v3.oas.annotations.Operation;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Operation(summary = "Login a user with a token")
    public ResponseEntity<LoginResponseDTO> login(AccountCredentialsVO accountCredentialsVO) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                accountCredentialsVO.getLogin(),
                accountCredentialsVO.getPassword());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);
        String token = jwtService.generateToken((Users) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @Operation(summary = "Register a user and return a token")
    public ResponseEntity<LoginResponseDTO> register(RegisterDTO registerDTO) {
        if (usersRepository.existsByLogin(registerDTO.login()))
            return ResponseEntity.badRequest().build();
        String password = new BCryptPasswordEncoder().encode(registerDTO.password());
        Users user = Users.builder()
                .login(registerDTO.login())
                .password(password)
                .role(registerDTO.role())
                .build();
        usersRepository.save(user);
        return ResponseEntity.ok().body(new LoginResponseDTO(user.getPassword()));
    }

    @Operation(summary = "List all users")
    public List<Users> listAll() {
        return usersRepository.findAll();
    }

}
