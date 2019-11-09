package com.alberto.gastos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoGasto {

    FIJO(0),
    VARIABLE(1);

    private int code;

}
