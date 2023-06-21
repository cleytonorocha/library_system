package com.github.cleyto_orocha.library_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.github.cleyto_orocha.library_system.entities.Product;

@NoRepositoryBean
public interface BaseProductRepository<T extends Product> extends JpaRepository<T, Long> {
    
}
