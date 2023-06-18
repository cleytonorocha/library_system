package com.github.cleyto_orocha.library_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.entities.Address;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.repositories.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new IdError());
    }

    public List<Address> findAll(Address address) {
        return addressRepository.findAll();
    }

    public Address include(Address address) {
        return addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.findById(id).map(m -> {
            addressRepository.delete(m);
            return Void.TYPE;
        }).orElseThrow(() -> new IdError());
    }

    public Address update(Address address, Long id) {
        return addressRepository.findById(id)
                .map(m -> {
                    address.setId(m.getId());
                    addressRepository.save(address);
                    return address;
                }).orElseThrow(() -> new IdError());
    }

}
