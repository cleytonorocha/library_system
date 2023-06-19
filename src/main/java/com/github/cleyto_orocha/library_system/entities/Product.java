package com.github.cleyto_orocha.library_system.entities;

import java.math.BigDecimal;

import com.github.cleyto_orocha.library_system.enums.TypeProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    @Id
    @Column(name = "idProduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduct;

    @Column(length = 200)
    @NotNull(message = "The product name's required")
    @NotEmpty(message = "The product name connot be empty")
    String name;

    @Column(length = 50)
    @NotNull(message = "The codBar's required")
    @NotEmpty(message = "The codBar connot be empty")
    String codBarr;

    @Enumerated(value = EnumType.ORDINAL)
    @NotNull(message = "The product type's required")
    @NotEmpty(message = "The product type connot be empty")
    TypeProduct type;

    @NotNull(message = "The price's required")
    @NotEmpty(message = "The product price connot be empty")
    BigDecimal price;
}
