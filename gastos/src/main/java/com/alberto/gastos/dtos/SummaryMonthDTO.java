package com.alberto.gastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SummaryMonthDTO {

    private List<RowSummaryOperationsDTO> operaciones;

    private ConfigurationDTO configuracion;

    private float disponibleDiario;

    private float totalGastos;

    private int saludEconomica;

}
