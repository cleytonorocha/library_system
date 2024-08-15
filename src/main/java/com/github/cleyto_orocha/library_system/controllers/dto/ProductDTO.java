package com.github.cleyto_orocha.library_system.controllers.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.enums.TypeProduct;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Hidden
    private Long id;

    @Schema(example = "backpack")
    @NotNull(message = "The product name's required")
    @NotEmpty(message = "The product name cannot be empty")
    private String name;

    @Schema(example = "51154046064")
    @NotNull(message = "The codBar's required")
    @NotEmpty(message = "The codBar cannot be empty")
    private String codBarr;

    @Schema(example = "0")
    @NotNull(message = "The product type's required")
    private TypeProduct type;

    @Schema(example = "19.99")
    @NotNull(message = "The price's required")
    private BigDecimal price;

    @Hidden
    private List<ClientDTO> listClientsdClientDTO;

    @Hidden
    private Set<AcquisitionDTO> operations;

    public static ProductDTO buildProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .codBarr(product.getCodBarr())
                .type(product.getType())
                .price(product.getPrice())
                .listClientsdClientDTO(product.getListClients()
                        .stream()
                        .map(ClientDTO::buildClientDTO)
                        .toList())
                .operations(product.getOperations()
                        .stream()
                        .map(AcquisitionDTO::buildAcquisitionDTO)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static Product buildProduct(ProductDTO productDTO) {
        Product product = new Product(null,
                productDTO.getName(),
                productDTO.getCodBarr(),
                productDTO.getType(),
                productDTO.getPrice(),
                productDTO.getListClientsdClientDTO()
                        .stream()
                        .map(ClientDTO::buildClient)
                        .toList(),
                productDTO.getOperations()
                        .stream()
                        .map(AcquisitionDTO::buildAcquisition)
                        .collect(Collectors.toSet()));
        return product;
    }

    public static Set<ProductDTO> toSetProductDTO(Set<Product> products) {
        return products.stream()
                .map(m -> ProductDTO.buildProductDTO(m))
                .collect(Collectors.toSet());
    }

}
