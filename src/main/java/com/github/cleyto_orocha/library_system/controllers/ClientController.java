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

import com.github.cleyto_orocha.library_system.entities.Client;
import com.github.cleyto_orocha.library_system.services.ClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {
    
    private final ClientService clientService;

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id){
        return clientService.findById(id);
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.listAll();
    }

    @PostMapping
    public Client include(@RequestBody @Valid Client client){
        return clientService.include(client);
    }
    
    @PutMapping("/{id}")
    public Client update(@PathVariable @Valid Long id, @RequestBody Client client) {
        return clientService.update(id, client);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }

}
