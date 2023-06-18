package com.github.cleyto_orocha.library_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cleyto_orocha.library_system.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
