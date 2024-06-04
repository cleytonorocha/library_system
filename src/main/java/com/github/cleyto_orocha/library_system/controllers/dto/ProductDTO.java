package com.github.cleyto_orocha.library_system.controllers.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.cleyto_orocha.library_system.entities.Acquisition;
import com.github.cleyto_orocha.library_system.entities.Client;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.enums.TypeProduct;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
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

    private List<Client> listClients;

    private Set<Acquisition> operations;

    public static ProductDTO buildProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .codBarr(product.getCodBarr())
                .type(product.getType())
                .price(product.getPrice())
                .listClients(product.getListClients())
                .operations(product.getOperations())
                .build();
    }

    public static Product buildProduct(ProductDTO productDTO) {
        Product product = new Product(null, productDTO.getName(), productDTO.getCodBarr(), productDTO.getType(),
                productDTO.getPrice(), productDTO.getListClients(), productDTO.getOperations());
        return product;
    }

    public static Set<ProductDTO> toSetProductDTO(Set<Product> products) {
        return products.stream()
                .map(m -> ProductDTO.buildProductDTO(m))
                .collect(Collectors.toSet());
    }

    public static Set<Product> toSetProduct(Set<ProductDTO> productsDTO) {
        return productsDTO.stream()
                .map(m -> ProductDTO.buildProduct(m))
                .collect(Collectors.toSet());
    }
}
