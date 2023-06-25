package com.github.cleyto_orocha.library_system.entities;

import java.math.BigDecimal;
import java.util.List;

import com.github.cleyto_orocha.library_system.entities.nxn.Client_Product;
import com.github.cleyto_orocha.library_system.entities.nxn.Product_Acquisition;
import com.github.cleyto_orocha.library_system.enums.TypeProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(length = 200)
    @NotNull(message = "The product name's required")
    @NotEmpty(message = "The product name cannot be empty")
    private String name;

    @Setter
    @Column(length = 50)
    @NotNull(message = "The codBar's required")
    @NotEmpty(message = "The codBar cannot be empty")
    private String codBarr;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "The product type's required")
    private TypeProduct type;

    @Setter
    @NotNull(message = "The price's required")
    private BigDecimal price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Client_Product> product;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Product_Acquisition> operations;

    public TypeProduct setType(Integer cod){
        return this.type = TypeProduct.toEnum(cod);
    }
}
