package com.github.cleyto_orocha.library_system.enums;

import com.github.cleyto_orocha.library_system.exception.IdError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AcquisitionStatus {
    FINALIZED(0, "Finalized"),
    PENDING(1, "Pending"),
    CANCELED(2,"Canceled");

    private final Integer cod;
    private final String description;

    public static AcquisitionStatus toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (AcquisitionStatus interable : AcquisitionStatus.values()) {
            if (cod.equals(interable.getCod()))
                return interable;
        }

        throw new IdError("Invalid aquisitionStatus code");
    }
}