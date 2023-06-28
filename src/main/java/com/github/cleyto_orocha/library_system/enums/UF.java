package com.github.cleyto_orocha.library_system.enums;

import com.github.cleyto_orocha.library_system.exception.IdError;

import lombok.Getter;

@Getter
public enum UF {
    AC(0, "Acre"),
    AL(1, "Alagoas"),
    AP(2, "Amapá"),
    AM(3, "Amazonas"),
    BA(4, "Bahia"),
    CE(5, "Ceará"),
    DF(6, "Distrito Federal"),
    ES(7, "Espírito Santo"),
    GO(8, "Goiás"),
    MA(9, "Maranhão"),
    MT(10, "Mato Grosso"),
    MS(11, "Mato Grosso do Sul"),
    MG(12, "Minas Gerais"),
    PA(13, "Pará"),
    PB(14, "Paraíba"),
    PR(15, "Paraná"),
    PE(16, "Pernambuco"),
    PI(17, "Piauí"),
    RJ(18, "Rio de Janeiro"),
    RN(19, "Rio Grande do Norte"),
    RS(20, "Rio Grande do Sul"),
    RO(21, "Rondônia"),
    RR(22, "Roraima"),
    SC(23, "Santa Catarina"),
    SP(24, "São Paulo"),
    SE(25, "Sergipe"),
    TO(26, "Tocantins");

    private final Integer cod;
    private final String description;

    UF(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static UF toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (UF interable : UF.values()) {
            if (cod.equals(interable.getCod()))
                return interable;
        }

        throw new IdError();

    }
}
