package com.github.cleyto_orocha.library_system.entities;

import java.time.Instant;
import java.util.List;

import com.github.cleyto_orocha.library_system.entities.nxn.Product_Acquisition;
import com.github.cleyto_orocha.library_system.enums.AcquisitionType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Acquisition {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @OneToMany(mappedBy = "acquisition", fetch = FetchType.LAZY)
     private List<Product_Acquisition> products;

     @Min(1)
     @Max(100)
     private Integer quantity;

     @NotNull(message = "The data of acquisition's required")
     private Instant acquisitionDate;

     @NotNull(message = "The type of acquisition's required")
     private Integer type;

     public void setType(AcquisitionType type) {
          this.type = type.getCod();
     }
}
