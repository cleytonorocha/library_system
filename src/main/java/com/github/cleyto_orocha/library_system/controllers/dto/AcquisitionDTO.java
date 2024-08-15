package com.github.cleyto_orocha.library_system.controllers.dto;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.cleyto_orocha.library_system.entities.Acquisition;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.enums.AcquisitionStatus;
import com.github.cleyto_orocha.library_system.enums.AcquisitionType;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
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

     @Hidden
     private Long id;

     @Schema(example = "[1,2]")
     private Set<Long> products;
     @Schema(example = "1")
     private Long clientId;

     @NotNull(message = "The data of acquisition's required")
     private Instant acquisitionDate;

     @Schema(example = "0")
     @NotNull(message = "The type of acquisition's required")
     private AcquisitionType type;

     @Schema(example = "0")
     @NotNull(message = "The status of acquisition cannot be null")
     private AcquisitionStatus status;

     public static AcquisitionDTO buildAcquisitionDTO(Acquisition acquisition) {
          return AcquisitionDTO.builder()
                    .id(acquisition.getId())
                    .products(acquisition.getProducts()
                              .stream()
                              .map(Product::getId)
                              .collect(Collectors.toSet()))
                    .clientId(acquisition.getClient().getId())
                    .acquisitionDate(acquisition.getAcquisitionDate())
                    .type(acquisition.getType())
                    .status(acquisition.getStatus())
                    .build();
     }

     public static Acquisition buildAcquisition(AcquisitionDTO acquisitionDTO) {
          return Acquisition.builder()
                    .id(acquisitionDTO.getId())
                    .acquisitionDate(acquisitionDTO.getAcquisitionDate())
                    .type(acquisitionDTO.getType())
                    .status(acquisitionDTO.getStatus())
                    .build();
     }

}
