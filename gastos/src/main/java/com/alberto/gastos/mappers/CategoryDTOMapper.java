package com.alberto.gastos.mappers;

import com.alberto.gastos.dtos.CategoryDTO;
import com.alberto.gastos.entidades.Category;

public class CategoryDTOMapper {

	public static Category map(CategoryDTO categoryDTO, boolean mapRelations){
		Category result = new Category();

		result.setCodCategoria(categoryDTO.getCodCategoria());
		result.setTxtNombre(categoryDTO.getTxtNombre());

		if(mapRelations){
			if(categoryDTO.getCategoriaPadre() != null){
				result.setFatherCategory(CategoryDTOMapper.map(categoryDTO.getCategoriaPadre(), true));
			}
		}

		return result;
	}

}
