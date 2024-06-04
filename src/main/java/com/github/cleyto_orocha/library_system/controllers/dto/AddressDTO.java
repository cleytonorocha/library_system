package com.github.cleyto_orocha.library_system.controllers.dto;

import com.github.cleyto_orocha.library_system.entities.Address;
import com.github.cleyto_orocha.library_system.enums.UF;

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
public class AddressDTO {

    private Long id;

    @NotNull(message = "The state is required")
    private UF state;

    @NotNull(message = "The city is required")
    @NotEmpty(message = "The city connot be empty")
    private String city;

    @NotNull(message = "The neighborhood is required")
    @NotEmpty(message = "The neighborhood connot be empty")
    private String neighborhood;

    @NotNull(message = "The street is required")
    @NotEmpty(message = "The street connot be empty")
    private String street;

    private ClientDTO client;

    public static AddressDTO buildAddressDTO(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .state(address.getState())
                .city(address.getCity())
                .neighborhood(address.getNeighborhood())
                .street(address.getStreet())
                .client(ClientDTO.buildClientDTO(address.getClient()))
                .build();
    }

    public static Address buildAddress(AddressDTO addressDTO, ClientDTO clientDTO) {
        return Address.builder()
        .id(addressDTO.getId())
        .state(addressDTO.getState())
        .city(addressDTO.getCity())
        .neighborhood(addressDTO.getNeighborhood())
        .street(addressDTO.getStreet())
        .client(ClientDTO.buildClient(clientDTO))
        .build();
    }

}
