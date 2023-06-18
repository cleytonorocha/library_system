package com.github.cleyto_orocha.library_system.entities;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode
public class Address {

    @Id
    @Column(name = "idAddress")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2)
    @NotNull(message = "The state is required")
    @NotEmpty(message = "The state connot be empty")
    private UF state;
    

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
    @JoinColumn(name = "id_client")
    private Client client;
}
