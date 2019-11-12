package com.alberto.gastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationDTO {

    private long codConfiguracion;

    private float numCantidadInicial;

    private float numAhorroDeseado;

    private int numAno;

    private int numMes;
}
