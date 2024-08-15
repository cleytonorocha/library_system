package com.github.cleyto_orocha.library_system.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    @NotNull(message = "The name is required")
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @Column(unique = true)
    @NotNull(message = "The CPF is required")
    @NotEmpty(message = "The CPF cannot be empty")
    private String cpf;

    @Embedded
    private Address address;

    @ManyToMany
    @JoinTable(name = "client_product", joinColumns = @JoinColumn(name = "id_client"), inverseJoinColumns = @JoinColumn(name = "id_product"))
    private Set<Product> whishList;

    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Acquisition> acquisitionList;

}
