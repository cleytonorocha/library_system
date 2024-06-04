package com.github.cleyto_orocha.library_system.entities;

import java.time.Instant;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.cleyto_orocha.library_system.enums.AcquisitionStatus;
import com.github.cleyto_orocha.library_system.enums.AcquisitionType;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Hidden
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acquisition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The data of acquisition's required")
    private Instant acquisitionDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "The type of acquisition's required")
    private AcquisitionType type;

    @ManyToMany
    @JoinTable(name = "acquisition_product", joinColumns = @JoinColumn(name = "id_product"), inverseJoinColumns = @JoinColumn(name = "id_acquisition"))
    private Set<Product> products;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_client")
    private Client client;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "The status of acquisition cannot be null")
    private AcquisitionStatus status;
}
