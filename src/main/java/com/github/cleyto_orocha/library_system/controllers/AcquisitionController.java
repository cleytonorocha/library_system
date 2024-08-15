package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.controllers.dto.AcquisitionDTO;
import com.github.cleyto_orocha.library_system.enums.AcquisitionStatus;
import com.github.cleyto_orocha.library_system.enums.SwaggerEnum;
import com.github.cleyto_orocha.library_system.services.AcquisitionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/acquisition")
@Tag(name = SwaggerEnum.ACQUISITION_TAG_NAME, description = SwaggerEnum.ACQUISITION_TAG_DESCRIPTION)
public class AcquisitionController {

    private final AcquisitionService acquisitionService;

    @Operation(summary = "Get a acquisition by id")
    @GetMapping("/{id}")
    public ResponseEntity<AcquisitionDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(acquisitionService.findById(id));
    }

    @Operation(summary = "Get all acquistions")
    @GetMapping
    public ResponseEntity<List<AcquisitionDTO>> findAll() {
        return ResponseEntity.ok().body(acquisitionService.findAll());
    }

    @Operation(summary = "Make a product acquisition", 
    description = "Before registering an acquisition, make sure the components are registered")
    @PostMapping
    public ResponseEntity<AcquisitionDTO> include(@RequestBody @Valid AcquisitionDTO acquisitionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(acquisitionService.include(acquisitionDTO));
    }

    @Operation(summary = "Modify the acquisition status")
    @PutMapping("/{id}")
    public ResponseEntity<AcquisitionStatus> modifyAcquisitionStatus(@PathVariable @Valid Long id,
            @RequestBody AcquisitionDTO acquisitionDTO) {
        return ResponseEntity.ok().body(acquisitionService.modifyAcquisitionStatus(id, acquisitionDTO));
    }

}
