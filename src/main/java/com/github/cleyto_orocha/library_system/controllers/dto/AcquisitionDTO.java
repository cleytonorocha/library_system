package com.github.cleyto_orocha.library_system.controllers.dto;

import java.time.Instant;
import java.util.Set;

import com.github.cleyto_orocha.library_system.entities.Acquisition;
import com.github.cleyto_orocha.library_system.enums.AcquisitionStatus;
import com.github.cleyto_orocha.library_system.enums.AcquisitionType;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcquisitionDTO {

     private Long id;
     private Set<ProductDTO> products;
     private ClientDTO client;

     @NotNull(message = "The data of acquisition's required")
     private Instant acquisitionDate;

     @NotNull(message = "The type of acquisition's required")
     private AcquisitionType type;

     @NotNull(message = "The status of acquisition cannot be null")
     private AcquisitionStatus status;

     public static AcquisitionDTO buildAcquisitionDTO(Acquisition acquisition) {
          return AcquisitionDTO.builder()
                    .id(acquisition.getId())
                    .products(ProductDTO.toSetProductDTO(acquisition.getProducts()))
                    .client(ClientDTO.buildClientDTO(acquisition.getClient()))
                    .acquisitionDate(acquisition.getAcquisitionDate())
                    .type(acquisition.getType())
                    .status(acquisition.getStatus())
                    .build();
     }

     public static Acquisition buildAcquisition(AcquisitionDTO acquisitionDTO) {
          return Acquisition.builder()
                    .id(acquisitionDTO.getId())
                    .products(ProductDTO.toSetProduct(acquisitionDTO.getProducts()))
                    .client(ClientDTO.buildClient(acquisitionDTO.getClient()))
                    .acquisitionDate(acquisitionDTO.getAcquisitionDate())
                    .type(acquisitionDTO.getType())
                    .status(acquisitionDTO.getStatus())
                    .build();
     }




}
