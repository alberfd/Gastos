package com.alberto.gastos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoOperacion {

    GASTO(0),
    INGRESO(1);

    private int code;

}
