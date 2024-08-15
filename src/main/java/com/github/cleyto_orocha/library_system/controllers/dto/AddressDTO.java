package com.github.cleyto_orocha.library_system.controllers.dto;

import com.github.cleyto_orocha.library_system.entities.Address;
import com.github.cleyto_orocha.library_system.enums.UF;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "12")
    @NotNull(message = "The state is required")
    private UF state;

    @Schema(example = "Vespasiano")
    @NotNull(message = "The city is required")
    @NotEmpty(message = "The city connot be empty")
    private String city;

    @Schema(example = "Serra Dourada")
    @NotNull(message = "The neighborhood is required")
    @NotEmpty(message = "The neighborhood connot be empty")
    private String neighborhood;

    @Schema(example = "Ae já é demais")
    @NotNull(message = "The street is required")
    @NotEmpty(message = "The street connot be empty")
    private String street;

    public static AddressDTO buildAddressDTO(Address address) {
        return AddressDTO.builder()
                .state(address.getState())
                .city(address.getCity())
                .neighborhood(address.getNeighborhood())
                .street(address.getStreet())
                .build();
    }

    public static Address buildAddress(AddressDTO addressDTO) {
        return Address.builder()
                .state(addressDTO.getState())
                .city(addressDTO.getCity())
                .neighborhood(addressDTO.getNeighborhood())
                .street(addressDTO.getStreet())
                .build();
    }

}
