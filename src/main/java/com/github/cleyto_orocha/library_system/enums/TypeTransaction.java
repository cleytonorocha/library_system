package com.github.cleyto_orocha.library_system.enums;

import com.github.cleyto_orocha.library_system.exception.IdError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum TypeTransaction {
    PURCHASE(1, "Purchase"),
    LOAN(2, "Loan");

    private final Integer cod;
    private final String description;

    public static TypeTransaction toEnum(Integer cod){
       if(cod == null) return null;

        for (TypeTransaction interable : TypeTransaction.values()) {
            if (cod.equals(interable.getCod())) return interable;
        }

        throw new IdError();
    }
}
