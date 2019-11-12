package com.alberto.gastos.mappers;

import com.alberto.gastos.dtos.CategoryDTO;
import com.alberto.gastos.entidades.Category;

public class CategoryMapper {

    public static CategoryDTO map(Category category, boolean mapRelations){
        CategoryDTO result = new CategoryDTO();

        result.setCodCategoria(category.getCodCategoria());
        result.setTxtNombre(category.getTxtNombre());

        if(mapRelations){
            if(category.getFatherCategory() != null) {
                CategoryDTO subCategory = CategoryMapper.map(category.getFatherCategory(), true);

                result.setCategoriaPadre(subCategory);
            }
        }

        return result;

    }
}
