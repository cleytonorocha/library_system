package com.github.cleyto_orocha.library_system.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.cleyto_orocha.library_system.enums.TypeProduct;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Hidden
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    @NotNull(message = "The product name's required")
    @NotEmpty(message = "The product name cannot be empty")
    private String name;

    @Column(length = 50)
    @NotNull(message = "The codBar's required")
    @NotEmpty(message = "The codBar cannot be empty")
    private String codBarr;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "The product type's required")
    private TypeProduct type;

    @NotNull(message = "The price's required")
    private BigDecimal price;

    @JsonIgnore
    @ManyToMany(mappedBy = "whishList")
    private List<Client> listClients;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private Set<Acquisition> operations;

}