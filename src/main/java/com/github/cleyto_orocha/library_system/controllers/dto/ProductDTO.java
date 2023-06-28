package com.github.cleyto_orocha.library_system.controllers.dto;

import java.math.BigDecimal;
import java.util.List;

import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.entities.nxn.Client_Product;
import com.github.cleyto_orocha.library_system.entities.nxn.Product_Acquisition;
import com.github.cleyto_orocha.library_system.enums.TypeProduct;

import jakarta.persistence.Entity;
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
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProductDTO extends Product{

    private Long id;

    @NotNull(message = "The product name's required")
    @NotEmpty(message = "The product name cannot be empty")
    private String name;

    @NotNull(message = "The codBar's required")
    @NotEmpty(message = "The codBar cannot be empty")
    private String codBarr;

    @NotNull(message = "The product type's required")
    private TypeProduct type;

    @NotNull(message = "The price's required")
    private BigDecimal price;

    private List<Client_Product> listClients;

    private List<Product_Acquisition> operations;

}
