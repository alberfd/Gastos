package com.alberto.gastos.mappers;

import com.alberto.gastos.dtos.OperationDTO;
import com.alberto.gastos.entidades.Operation;
import com.alberto.gastos.entidades.OperationType;

public class OperationMapper {

    public static OperationDTO map(Operation operation, boolean mapRelations){
        OperationDTO result = new OperationDTO();

        result.setCodOperacion(operation.getCodOperacion());
        result.setTxtConcepto(operation.getTxtConcepto());
        result.setTxtNota(operation.getTxtNota());
        result.setNumCantidad(operation.getNumCantidad());
        result.setTipoOperacion(OperationTypeMapper.map(OperationType.fromCode(operation.getIndTipo())));

        if(mapRelations){
            //todas las operaciones tienen categoria
            result.setCategoria(CategoryMapper.map(operation.getCategory(), false));
        }

        return result;


    }

}
