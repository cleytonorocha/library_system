package com.github.cleyto_orocha.library_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.entities.Paper;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.repositories.PaperRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaperServices {
    
    private final PaperRepository paperRepository;

    public List<Product> findAllPaper() {
        return paperRepository.findAll();
    }
    
    public Paper includePaper(Paper paper){
        return paperRepository.save(paper);
    }
}
