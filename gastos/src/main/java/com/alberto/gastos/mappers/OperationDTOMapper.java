package com.alberto.gastos.mappers;

import com.alberto.gastos.dtos.OperationDTO;
import com.alberto.gastos.entidades.Operation;

public class OperationDTOMapper {


	public static Operation map(OperationDTO operationDTO, boolean mapRelations){
		Operation result = new Operation();

		result.setCodOperacion(operationDTO.getCodOperacion());
		result.setDatFecha(operationDTO.getDatFecha());
		result.setTxtConcepto(operationDTO.getTxtConcepto());
		result.setTxtNota(operationDTO.getTxtNota());
		result.setIndTipo(operationDTO.getTipoOperacion().getCode());

		if(mapRelations){
			if(operationDTO.getCategoria() != null){
				result.setCategory(CategoryDTOMapper.map(operationDTO.getCategoria(), true));
			}
		}

		return result;
	}

}
