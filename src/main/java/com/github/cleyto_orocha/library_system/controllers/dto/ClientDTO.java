package com.github.cleyto_orocha.library_system.controllers.dto;

import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import com.github.cleyto_orocha.library_system.entities.Acquisition;
import com.github.cleyto_orocha.library_system.entities.Address;
import com.github.cleyto_orocha.library_system.entities.Client;
import com.github.cleyto_orocha.library_system.entities.Product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long id;

    @NotNull(message = "The name is required")
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @CPF(message = "Invalid Brazilian individual taxpayer registration number (CPF)")
    @NotNull(message = "The CPF is required")
    @NotEmpty(message = "The CPF cannot be empty")
    private String CPF;

    private Address address;

    private Set<Product> whishList;

    private Set<Acquisition> acquisitionList;

    public static ClientDTO buildClientDTO(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .CPF(client.getCPF())
                .address(client.getAddress())
                .acquisitionList(client.getAcquisitionList())
                .build();
    }

    public static Client buildClient(ClientDTO clientDTO) {
        return Client.builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .CPF(clientDTO.getCPF())
                .address(clientDTO.getAddress())
                .acquisitionList(clientDTO.getAcquisitionList())
                .build();
    }
}
