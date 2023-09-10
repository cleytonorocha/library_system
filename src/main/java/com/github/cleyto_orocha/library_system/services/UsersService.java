package com.github.cleyto_orocha.library_system.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.repositories.UsersRepository;

import lombok.RequiredArgsConstructor;

// É o serviço chamado automáticamente pelo security quando um usuário precisar a se identificar e fala pro spring security como fazer a autenticação.
// A UserDetailsService dá esse contexto ao spring.
@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User or password not found"));
    }

}
