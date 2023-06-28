package com.github.cleyto_orocha.library_system.controllers.dto;

import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import com.github.cleyto_orocha.library_system.entities.Acquisition;
import com.github.cleyto_orocha.library_system.entities.Address;
import com.github.cleyto_orocha.library_system.entities.Client;
import com.github.cleyto_orocha.library_system.entities.nxn.Client_Product;

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
    
    @CPF
    @NotNull(message = "The CPF is required")
    @NotEmpty(message = "The CPF cannot be empty")
    private String CPF;
    
    private Address address;

    private Set<Client_Product> whishList;
    
    private List<Acquisition> acquitionList;
    
    public static ClientDTO buildClientDTO(Client client){
        return ClientDTO.builder()
        .id(client.getId())
        .CPF(client.getCPF())
        .address(client.getAddress())
        .whishList(client.getWhishList())
        .acquitionList(client.getAcquitionList())
        .build();
    }

    public static Client buildClient(ClientDTO clientDTO){
        return Client.builder()
        .id(clientDTO.getId())
        .CPF(clientDTO.getCPF())
        .address(clientDTO.getAddress())
        .whishList(clientDTO.getWhishList())
        .acquitionList(clientDTO.getAcquitionList())
        .build();
    }
}
