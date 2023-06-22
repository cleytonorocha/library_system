package com.github.cleyto_orocha.library_system.entities;

import java.math.BigDecimal;
import java.util.List;

import com.github.cleyto_orocha.library_system.enums.TypeProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

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

    @NotNull(message = "The product type's required")
    private Integer type;

    @NotNull(message = "The price's required")
    private BigDecimal price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Client_Product> product;

    public void setType(TypeProduct type) {
        this.type = type.getCod();
    }

}
