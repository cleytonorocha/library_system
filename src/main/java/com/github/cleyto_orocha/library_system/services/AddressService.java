package com.github.cleyto_orocha.library_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.controllers.dto.AddressDTO;
import com.github.cleyto_orocha.library_system.entities.Address;
import com.github.cleyto_orocha.library_system.entities.Client;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.repositories.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final ClientService clientService;

    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new IdError());
    }

    public List<Address> findAll(Address address) {
        return addressRepository.findAll();
    }

    public Address include(AddressDTO addressDTO) {
        Address address = buildAddress(addressDTO, clientService.findById(addressDTO.getClient()));
        addressRepository.save(address);
        return address;
    }

    private static Address buildAddress(AddressDTO addressDTO, Client client) {
        return Address.builder()
                .state(addressDTO.getState())
                .city(addressDTO.getCity())
                .neighborhood(addressDTO.getNeighborhood())
                .street(addressDTO.getStreet())
                .client(client)
                .build();
    }

    public void delete(Long id) {
        addressRepository.findById(id).map(m -> {
            addressRepository.delete(m);
            return Void.TYPE;
        }).orElseThrow(() -> new IdError());
    }

    public Address update(AddressDTO addressDTO, Long id) {
        Client client = clientService.findById(addressDTO.getClient());
        Address address = buildAddress(addressDTO, client);

        address.setId(client.getId());
        addressRepository.save(address);
        return address;

    }

}
