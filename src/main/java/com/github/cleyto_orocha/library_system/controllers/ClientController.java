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

import com.github.cleyto_orocha.library_system.controllers.dto.ClientDTO;
import com.github.cleyto_orocha.library_system.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
@Tag(name = "Client", description = "Client operations - ")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Get a client by id")
    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @Operation(summary = "Get all clients")
    @GetMapping
    public List<ClientDTO> findAll() {
        return clientService.listAll();
    }

    @Operation(summary = "Save a client")
    @PostMapping
    public Long include(@RequestBody @Valid ClientDTO clientDTO) {
        clientDTO.setId(null);
        return clientService.include(clientDTO);
    }

    @Operation(summary = "Delete a client by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

    @Operation(summary = "Update a client by id")
    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable @Valid Long id, @RequestBody ClientDTO clientDTO) {
        return clientService.update(id, clientDTO);
    }

}
