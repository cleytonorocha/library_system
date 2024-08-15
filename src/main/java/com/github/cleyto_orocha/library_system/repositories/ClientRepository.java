package com.github.cleyto_orocha.library_system.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cleyto_orocha.library_system.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{
    public Optional<Boolean> findByCpf(String cpf);
}
