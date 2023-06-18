package com.github.cleyto_orocha.library_system.entities;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "tb_client")
@AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode
public class Client {

    @Id
    @Setter
    @Column(name = "idClient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(length = 200)
    @NotNull(message = "The name is required")
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @CPF
    @Setter
    @NotNull(message = "The CPF is required")
    @NotEmpty(message = "The CPF cannot be empty")
    private String CPF;

    @Setter
    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY)
    private Address address;

}
