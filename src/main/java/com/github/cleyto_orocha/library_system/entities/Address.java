package com.github.cleyto_orocha.library_system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.cleyto_orocha.library_system.enums.UF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The state is required")
    private Integer state;

    @Column(length = 100)
    @NotNull(message = "The city is required")
    @NotEmpty(message = "The city connot be empty")
    private String city;

    @Column(length = 100)
    @NotNull(message = "The neighborhood is required")
    @NotEmpty(message = "The neighborhood connot be empty")
    private String neighborhood;

    @Column(length = 100)
    @NotNull(message = "The street is required")
    @NotEmpty(message = "The street connot be empty")
    private String street;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "id_client")
    private Client client;

    public Address(Long id, Integer cod, String city, String neighborhood, String street) {
        this.id = id;
        this.state = UF.toEnum(cod).getCod();
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
    }
    
}
