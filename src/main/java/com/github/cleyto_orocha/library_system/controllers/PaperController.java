package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.entities.Paper;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.services.PaperServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products/paper")
public class PaperController {

    private final PaperServices paperServices;

    @GetMapping("/paper")
    public List<Product> findAllPaper(){
        return paperServices.findAllPaper();
    }

    @PostMapping("/paper")
    public Paper includePaper(@RequestBody @Valid Paper paper){
        return paperServices.includePaper(paper);
    }
    
}
