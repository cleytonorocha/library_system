package com.github.cleyto_orocha.library_system.enums;

import com.github.cleyto_orocha.library_system.exception.IdError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AcquisitionType {
    PURCHASE(0, "Purchase"),
    LOAN(1, "Loan");

    private final Integer cod;
    private final String description;

    public static AcquisitionType toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (AcquisitionType interable : AcquisitionType.values()) {
            if (cod.equals(interable.getCod()))
                return interable;
        }

        throw new IdError("Invalid acquisitionType code");
    }
}
