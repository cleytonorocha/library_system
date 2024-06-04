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

import com.github.cleyto_orocha.library_system.controllers.dto.ClientDTO;
import com.github.cleyto_orocha.library_system.enums.SwaggerEnum;
import com.github.cleyto_orocha.library_system.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
@Tag(name = SwaggerEnum.CLIENT_TAG_NAME, description = SwaggerEnum.CLIENT_TAG_DESCRIPTION)
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Get a client by id")
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.findById(id);
        return ResponseEntity.ok().body(clientDTO);
    }

    @Operation(summary = "Get all clients")
    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<ClientDTO> clientDTOs = clientService.listAll();
        return ResponseEntity.ok().body(clientDTOs);
    }

    @Operation(summary = "Save a client")
    @PostMapping
    public ResponseEntity<String> include(@RequestBody @Valid ClientDTO clientDTO) {
        Long clientId = clientService.include(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Client id: " + clientId);
    }

    @Operation(summary = "Delete a client by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().body("Client deleted with success");
    }

    @Operation(summary = "Update a client by id")
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable @Valid Long id, @RequestBody ClientDTO clientDTO) {
        ClientDTO updatedClient = clientService.update(id, clientDTO);
        return ResponseEntity.ok().body(updatedClient);
    }

}
