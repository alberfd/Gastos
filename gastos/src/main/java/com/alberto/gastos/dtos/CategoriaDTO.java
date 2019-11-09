package com.alberto.gastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private long codCategoria;

    private String txtNombre;

    private CategoriaDTO categoriaPadre;

}
