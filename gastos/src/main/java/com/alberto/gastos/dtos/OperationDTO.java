package com.alberto.gastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {

    private long codOperacion;

    private String txtConcepto;

    private String txtNota;

    private OperationTypeDTO tipoOperacion;

    private float numCantidad;

    private CategoryDTO categoria;
}
