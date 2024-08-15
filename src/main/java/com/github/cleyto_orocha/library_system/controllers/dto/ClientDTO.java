package com.github.cleyto_orocha.library_system.controllers.dto;

import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import com.github.cleyto_orocha.library_system.entities.Acquisition;
import com.github.cleyto_orocha.library_system.entities.Client;
import com.github.cleyto_orocha.library_system.entities.Product;

import io.swagger.v3.oas.annotations.Hidden;
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
public class ClientDTO {

        @Hidden
        private Long id;

        @Schema(example = "Cleyton")
        @NotNull(message = "The name is required")
        @NotEmpty(message = "The name cannot be empty")
        private String name;

        @Schema(example = "09125867024")
        @NotNull(message = "The CPF is required")
        @NotEmpty(message = "The CPF cannot be empty")
        @CPF(message = "Invalid Brazilian individual taxpayer registration number (CPF)")
        private String cpf;

        private AddressDTO addressDTO;

        @Hidden
        private Set<Product> whishList;

        @Hidden
        private Set<Acquisition> acquisitionList;

        public static ClientDTO buildClientDTO(Client client) {
                return ClientDTO.builder()
                                .id(client.getId())
                                .name(client.getName())
                                .cpf(client.getCpf())
                                .addressDTO(AddressDTO.buildAddressDTO(client.getAddress()))
                                .acquisitionList(client.getAcquisitionList())
                                .build();
        }

        public static Client buildClient(ClientDTO clientDTO) {
                return Client.builder()
                                .id(clientDTO.getId())
                                .name(clientDTO.getName())
                                .cpf(clientDTO.getCpf())
                                .acquisitionList(clientDTO.getAcquisitionList())
                                .address(AddressDTO.buildAddress(clientDTO.getAddressDTO()))
                                .build();
        }
}
