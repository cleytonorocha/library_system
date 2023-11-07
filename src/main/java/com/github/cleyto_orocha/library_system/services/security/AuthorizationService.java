package com.github.cleyto_orocha.library_system.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.repositories.UsersRepository;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User or password not found"));

    }
}