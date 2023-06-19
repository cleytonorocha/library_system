package com.github.cleyto_orocha.library_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.github.cleyto_orocha.library_system.entities.Product;

@NoRepositoryBean
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
