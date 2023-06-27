package com.github.cleyto_orocha.library_system.controllers.dto;

import java.time.Instant;
import java.util.List;

import com.github.cleyto_orocha.library_system.entities.Acquisition;
import com.github.cleyto_orocha.library_system.entities.Client;
import com.github.cleyto_orocha.library_system.entities.nxn.Product_Acquisition;
import com.github.cleyto_orocha.library_system.enums.AcquisitionType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
     private List<Product_Acquisition> products;
     private Client client;

     @Min(1)
     @Max(100)
     private Integer quantity;

     @NotNull(message = "The data of acquisition's required")
     private Instant acquisitionDate;

     @NotNull(message = "The type of acquisition's required")
     private AcquisitionType type;

     public static AcquisitionDTO buildAcquisitionDTO(Acquisition acquisition){
          return AcquisitionDTO.builder()
          .id(acquisition.getId())
          .products(acquisition.getProducts())
          .client(acquisition.getClient())
          .quantity(acquisition.getQuantity())
          .acquisitionDate(acquisition.getAcquisitionDate())
          .type(acquisition.getType())
          .build();
     }
}
