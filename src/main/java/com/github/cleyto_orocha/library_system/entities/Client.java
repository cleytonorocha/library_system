package com.github.cleyto_orocha.library_system.entities;

import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.cleyto_orocha.library_system.entities.nxn.Client_Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 200)
    @NotNull(message = "The name is required")
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @CPF
    @NotNull(message = "The CPF is required")
    @NotEmpty(message = "The CPF cannot be empty")
    private String CPF;

    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Client_Product> whishList;

    @OneToMany
    private List<Acquisition> acquitionList;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY)
    private Address address;

}
