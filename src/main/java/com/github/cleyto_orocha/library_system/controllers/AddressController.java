package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.controllers.dto.AddressDTO;
import com.github.cleyto_orocha.library_system.enums.SwaggerEnum;
import com.github.cleyto_orocha.library_system.services.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/address")
@Tag(name = SwaggerEnum.ADDRESS_TAG_NAME, description = SwaggerEnum.ADDRESS_TAG_DESCRIPTION)
public class AddressController {

    private final AddressService addressService;


    @Operation(summary = "Get a address by id")
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id) {
        AddressDTO address = addressService.findById(id);
        return ResponseEntity.ok().body(address);
    }

    @Operation(summary = "Get all address")
    @GetMapping()
    public ResponseEntity<List<AddressDTO>> findAll() {
        List<AddressDTO> addressList = addressService.findAll();
        return ResponseEntity.ok().body(addressList);
    }

    @Operation(summary = "Set a address to a client by id")
    @PostMapping
    public ResponseEntity<Long> include(@RequestBody @Valid AddressDTO addressDTO) {
        Long addressId = addressService.include(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressId);
    }

    @Operation(summary = "Delete a address by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update a address by id")
    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO, @PathVariable @Valid Long id) {
        AddressDTO updatedAddress = addressService.update(addressDTO, id);
        return ResponseEntity.ok().body(updatedAddress);
    }

}
