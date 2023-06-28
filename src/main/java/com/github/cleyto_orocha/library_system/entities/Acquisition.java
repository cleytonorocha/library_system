package com.github.cleyto_orocha.library_system.entities;

import java.time.Instant;
import java.util.List;

import com.github.cleyto_orocha.library_system.entities.nxn.Product_Acquisition;
import com.github.cleyto_orocha.library_system.enums.AcquisitionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

     @ManyToOne
     @JoinColumn(name = "id_client")
     private Client client;

     @Min(1)
     @Max(100)
     private Integer quantity;

     @NotNull(message = "The data of acquisition's required")
     private Instant acquisitionDate;

     @Enumerated(EnumType.STRING)
     @NotNull(message = "The type of acquisition's required")
     private AcquisitionType type;

}
