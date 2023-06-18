package com.github.cleyto_orocha.library_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.entities.Client;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IdError());
    }

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public Client include(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.findById(id)
                .map(m -> {
                    clientRepository.delete(m);
                    return Void.TYPE;
                }).orElseThrow(() -> new IdError());
    }

    public Client update(Long id, Client client) {
        return clientRepository.findById(id)
                .map(f -> {
                    client.setId(f.getId());
                    clientRepository.save(client);
                    return client;
                })
                .orElseThrow(() -> new IdError());
    }

}
