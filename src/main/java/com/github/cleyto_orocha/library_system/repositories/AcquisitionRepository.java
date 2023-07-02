package com.github.cleyto_orocha.library_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cleyto_orocha.library_system.entities.Acquisition;

public interface AcquisitionRepository extends JpaRepository<Acquisition,Long>{
    
}
