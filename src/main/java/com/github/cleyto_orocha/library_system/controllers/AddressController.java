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
import com.github.cleyto_orocha.library_system.entities.Address;
import com.github.cleyto_orocha.library_system.services.AddressService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/address")
public class AddressController {


    private final AddressService addressService;
    
    private final AddressService addressService;

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id){

        return addressService.findById(id);
    }

    @GetMapping()
    public List<Address> findAll(Address address) {
        return addressService.findAll(address);
    }

    @PostMapping
    public Address include(@RequestBody @Valid AddressDTO addressDTO) {
        return addressService.include(addressDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

    @PostMapping()
    public Address include(@RequestBody @Valid Address address){
        return addressService.include(address);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        addressService.delete(id);
    }

    @PutMapping("/{id}")
    public Address update(@RequestBody AddressDTO addressDTO, @PathVariable @Valid Long id) {
        return addressService.update(addressDTO, id);
    }
      
    

}
