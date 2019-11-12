package com.alberto.gastos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum OperationType {

    GASTO_VARIABLE((short) 0, "Gasto Variable"),
    GASTO_FIJO((short) 1, "Gasto Fijo"),

    INGRESO_VARIABLE((short) 2, "Ingreso Variable"),
    INGRESO_FIJO((short) 3, "Ingreso Fijo");

    private short code;
    private String literal;

    public static OperationType fromCode(short code) {
        for(OperationType operationType : values()) {
            if(operationType.code == code) return operationType;
        }

        return null;
    }


}
