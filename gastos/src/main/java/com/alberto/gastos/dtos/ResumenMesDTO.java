package com.alberto.gastos.dtos;

import com.alberto.gastos.entidades.Operacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumenMesDTO {

    private List<OperacionDTO> operaciones;

    private ConfiguracionDTO configuracion;

    private float disponibleDiario;

    private int saludEconomica;

}
