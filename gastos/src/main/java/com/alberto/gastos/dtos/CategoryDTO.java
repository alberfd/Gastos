package com.alberto.gastos.dtos;

import com.alberto.gastos.entidades.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private long codCategoria;

    private String txtNombre;

    private CategoryDTO categoriaPadre;

    @Override
    public boolean equals(Object categoryDTO){
        if(! (categoryDTO instanceof CategoryDTO)){
            return false;
        }

        if(((CategoryDTO) categoryDTO).getCodCategoria() == this.getCodCategoria()){
            return true;
        }else{
            return false;
        }
    }

}
