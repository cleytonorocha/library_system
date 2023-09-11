package com.github.cleyto_orocha.library_system.services;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.controllers.dto.AuthenticationDTO;
import com.github.cleyto_orocha.library_system.controllers.dto.RegisterDTO;
import com.github.cleyto_orocha.library_system.entities.Users;
import com.github.cleyto_orocha.library_system.repositories.UsersRepository;

import lombok.RequiredArgsConstructor;

// É o serviço chamado automáticamente pelo security quando um usuário precisar a se identificar e fala pro spring security como fazer a autenticação.
// A UserDetailsService dá esse contexto ao spring.
@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

    private AuthenticationManager authenticationManager;
    private UsersRepository usersRepository;

    public void login(AuthenticationDTO data) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authenticate = this.authenticationManager.authenticate(userNamePassword);
    }

    public ResponseEntity<Users> register(RegisterDTO data) {
        if (usersRepository.findByLogin(data.login()).isPresent())
            return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        return ResponseEntity.ok().body(usersRepository.save(new Users(data.login(), encryptedPassword, data.role())));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User or password not found"));
    }

}
