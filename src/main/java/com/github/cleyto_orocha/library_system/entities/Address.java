package com.github.cleyto_orocha.library_system.entities;

import com.github.cleyto_orocha.library_system.enums.UF;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Hidden
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "The state is required")
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
}

