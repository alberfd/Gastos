package com.alberto.gastos.servicios;

import com.alberto.gastos.dtos.OperationDTO;
import com.alberto.gastos.entidades.Operation;
import com.alberto.gastos.entidades.FixedOperation;
import com.alberto.gastos.mappers.OperacionMapper;
import com.alberto.gastos.repositorios.OperationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationJpaRepository operationJpaRepository;

    @Autowired
    private FixedOperationService fixedOperationService;


    public List<OperationDTO> getAllByMonth(int month, int year){
        List<Operation> operations = operationJpaRepository.getAllByMonth(month, year);
        List<OperationDTO> result = new ArrayList<>();

        for(Operation operation: operations){
            result.add(OperacionMapper.map(operation, true));
        }

        return result;

    }

    public OperationDTO addOperacion(OperationDTO operation){
        return null;
        //return operationJpaRepository.save(operation);
    }

    public void deleteOperacion(long codGasto){
        operationJpaRepository.deleteById(codGasto);
    }

    @Transactional
    public Operation addOperacionByOperacionFijaId(long codOperacionFija){
        FixedOperation fixedOperation = fixedOperationService.getById(codOperacionFija);

        Operation nuevaOperation = new Operation();

        nuevaOperation.setTxtConcepto(fixedOperation.getTxtConcepto());
        nuevaOperation.setTxtNota(fixedOperation.getTxtNota());
        nuevaOperation.setNumCantidad(fixedOperation.getNumCantidad());
        nuevaOperation.setIndTipo(fixedOperation.getIndTipo());
        nuevaOperation.setDatFecha(LocalDateTime.now());
        nuevaOperation.setCategory(fixedOperation.getCategory());

        return operationJpaRepository.save(nuevaOperation);
    }


}
