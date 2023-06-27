package com.github.cleyto_orocha.library_system.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.controllers.dto.AddressDTO;
import com.github.cleyto_orocha.library_system.entities.Address;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.repositories.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final ClientService clientService;

    public AddressDTO findById(Long id) {
        return AddressDTO.buildAddressDTO(addressRepository.findById(id)
                        .orElseThrow(() -> new IdError()));
    }

    public List<AddressDTO> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(m -> AddressDTO.buildAddressDTO(m))
                .collect(Collectors.toList());
    }

    public Long include(AddressDTO addressDTO) {
        return addressRepository.save(
                AddressDTO.buildAddress(
                        addressDTO,
                        clientService.findById(addressDTO.getClient().getId())))
                .getId();
    }

    public void delete(Long id) {
        addressRepository.findById(id).map(m -> {
            addressRepository.delete(m);
            return Void.TYPE;
        }).orElseThrow(() -> new IdError());
    }

    public AddressDTO update(AddressDTO addressDTO, Long id) {
        Address address = AddressDTO.buildAddress(addressDTO, clientService.findById(addressDTO.getClient().getId()));
        address.setId(id);
        addressRepository.save(address);
        return AddressDTO.buildAddressDTO(address);
    }

}
