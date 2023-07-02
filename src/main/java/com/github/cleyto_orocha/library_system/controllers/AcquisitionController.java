package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.controllers.dto.AcquisitionDTO;
import com.github.cleyto_orocha.library_system.enums.AcquisitionStatus;
import com.github.cleyto_orocha.library_system.services.AcquisitionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/acquisition")
public class AcquisitionController {
    
    private final AcquisitionService acquisitionService;

    @GetMapping("/{id}")
    public AcquisitionDTO findById(@PathVariable Long id){
        return acquisitionService.findById(id);
    }

    @GetMapping
    public List<AcquisitionDTO> findAll(){
        return acquisitionService.findAll();
    }

    @PostMapping
    public AcquisitionDTO include(@RequestBody @Valid AcquisitionDTO acquisitionDTO){
        return acquisitionService.include(acquisitionDTO);
    }

    @PatchMapping("/{id}")
    public AcquisitionStatus modifyAcquisitionStatus(@PathVariable @Valid Long id, @RequestBody AcquisitionDTO acquisitionDTO){
        return acquisitionService.modifyAcquisitionStatus(id, acquisitionDTO);
    }

}
