package com.alberto.gastos.mappers;

import com.alberto.gastos.dtos.CategoriaDTO;
import com.alberto.gastos.entidades.Categoria;

public class CategoriaMapper {

    public static CategoriaDTO map(Categoria categoria, boolean mapRelations){
        CategoriaDTO result = new CategoriaDTO();

        result.setCodCategoria(categoria.getCodCategoria());
        result.setTxtNombre(categoria.getTxtNombre());

        if(mapRelations){
            if(categoria.getCategoria() != null) {
                CategoriaDTO subCategory = CategoriaMapper.map(categoria.getCategoria(), false);

                result.setCategoriaPadre(subCategory);
            }
        }

        return result;

    }
}
