package com.github.cleyto_orocha.library_system.enums;

import com.github.cleyto_orocha.library_system.exception.IdError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum TypeProduct {
    BOOK(1, "Book"),
    MATERIAL(2, "Material");

    private final Integer cod;
    private final String description;

    public static TypeProduct toEnum(Integer cod){
        if(cod == null) return null;
                
        for (TypeProduct interable : TypeProduct.values()) {
            if (cod.equals(interable.getCod())) return interable;
        }

        throw new IdError();

    }
}
