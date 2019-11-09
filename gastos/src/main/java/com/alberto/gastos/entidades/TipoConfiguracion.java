package com.alberto.gastos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoConfiguracion {

    SALDO_INICIAL(0),
    AHORRO_DESEADO(1);

    private int code;
}
