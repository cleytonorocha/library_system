package com.github.cleyto_orocha.library_system.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.controllers.dto.AcquisitionDTO;
import com.github.cleyto_orocha.library_system.controllers.dto.ClientDTO;
import com.github.cleyto_orocha.library_system.controllers.dto.ProductDTO;
import com.github.cleyto_orocha.library_system.entities.Acquisition;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.enums.AcquisitionStatus;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.repositories.AcquisitionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcquisitionService {

    private final AcquisitionRepository acquisitionRepository;
    private final ClientService clientService;
    private final ProductService productService;

    public AcquisitionDTO findById(Long id) {
        return AcquisitionDTO.buildAcquisitionDTO(acquisitionRepository.findById(id)
                .orElseThrow(() -> new IdError("Invalid acquisition code")));
    }

    public List<AcquisitionDTO> findAll() {
        return acquisitionRepository.findAll()
                .stream()
                .map(m -> AcquisitionDTO.buildAcquisitionDTO(m))
                .collect(Collectors.toList());
    }

    public AcquisitionDTO include(AcquisitionDTO acquisitionDTO) {
        Acquisition acquisition = AcquisitionDTO.buildAcquisition(acquisitionDTO);
        acquisition.setProducts(
                acquisitionDTO.getProducts()
                        .stream()
                        .map(m -> {
                            Product product = productService.findProductById(m);
                            ProductDTO.buildProductDTO(product);
                            return product;
                        }).collect(Collectors.toSet()));

        acquisition.setClient(
                ClientDTO.buildClient(
                        clientService.findById(
                                acquisitionDTO.getClientId())));

        return AcquisitionDTO.buildAcquisitionDTO(acquisitionRepository.save(acquisition));
    }

    public AcquisitionStatus modifyAcquisitionStatus(Long id, AcquisitionDTO acquisitionDTO) {
        return acquisitionRepository.findById(id)
                .map(m -> {
                    m.setStatus(acquisitionDTO.getStatus());
                    return acquisitionRepository.save(m).getStatus();
                }).orElseThrow(() -> new IdError("Invalid acquisition code"));
    }
}
