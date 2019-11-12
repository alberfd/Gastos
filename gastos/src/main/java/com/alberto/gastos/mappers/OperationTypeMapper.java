package com.alberto.gastos.mappers;

import com.alberto.gastos.dtos.OperationTypeDTO;
import com.alberto.gastos.entidades.OperationType;

public class OperationTypeMapper {

    public static OperationTypeDTO map(OperationType operationType){
        OperationTypeDTO result = new OperationTypeDTO();

        result.setCode(operationType.getCode());
        result.setLiteral(operationType.getLiteral());

        return result;
    }



}
