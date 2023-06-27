package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.controllers.dto.AddressDTO;
import com.github.cleyto_orocha.library_system.services.AddressService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{id}")
    public AddressDTO findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @GetMapping()
    public List<AddressDTO> findAll() {
        return addressService.findAll();
    }

    @PostMapping
    public Long include(@RequestBody @Valid AddressDTO addressDTO) {
        return addressService.include(addressDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }

    @PutMapping("/{id}")
    public AddressDTO update(@RequestBody AddressDTO addressDTO, @PathVariable @Valid Long id) {
        return addressService.update(addressDTO, id);
    }

}
