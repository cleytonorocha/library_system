package com.github.cleyto_orocha.library_system.controllers.dto;

import java.util.stream.Collectors;

import com.github.cleyto_orocha.library_system.entities.Paper;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class PaperDTO extends ProductDTO {

    @Min(10)
    @Max(100000)
    @Schema(example = "430")
    @NotNull(message = "The number of sheets cannot be null")
    private Integer leaves;

    public static PaperDTO buildPaperDTO(Paper paper) {
        return PaperDTO.builder()
                .id(paper.getId())
                .name(paper.getName())
                .codBarr(paper.getCodBarr())
                .type(paper.getType())
                .price(paper.getPrice())
                .listClientsdClientDTO(paper.getListClients()
                        .stream()
                        .map(ClientDTO::buildClientDTO)
                        .toList())
                .operations(paper.getOperations()
                        .stream()
                        .map(AcquisitionDTO::buildAcquisitionDTO)
                        .collect(Collectors.toSet()))
                .leaves(paper.getLeaves())
                .build();
    }

    public static Paper buildPaper(PaperDTO PaperDTO) {
        return Paper.builder()
                .id(PaperDTO.getId())
                .name(PaperDTO.getName())
                .codBarr(PaperDTO.getCodBarr())
                .type(PaperDTO.getType())
                .price(PaperDTO.getPrice())
                .leaves(PaperDTO.getLeaves())
                .build();
    }

}
