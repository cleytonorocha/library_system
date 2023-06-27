package com.github.cleyto_orocha.library_system.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.controllers.dto.ClientDTO;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientDTO findById(Long id) {
        return ClientDTO.buildClientDTO(clientRepository.findById(id)
                .orElseThrow(() -> new IdError()));
    }

    public List<ClientDTO> listAll() {
        return clientRepository.findAll()
                .stream()
                .map(m -> ClientDTO.buildClientDTO(m))
                .collect(Collectors.toList());
    }

    public Long include(ClientDTO clientDTO) {
        return clientRepository.save(
                ClientDTO.buildClient(clientDTO))
                .getId();
    }

    public void delete(Long id) {
        clientRepository.findById(id)
                .map(m -> {
                    clientRepository.delete(m);
                    return Void.TYPE;
                }).orElseThrow(() -> new IdError());
    }

    public ClientDTO update(Long id, ClientDTO clientDTO) {
        return clientRepository.findById(id)
                .map(f -> {
                    clientDTO.setId(f.getId());
                    clientRepository.save(ClientDTO.buildClient(clientDTO));
                    return clientDTO;
                })
                .orElseThrow(() -> new IdError());
    }

}
