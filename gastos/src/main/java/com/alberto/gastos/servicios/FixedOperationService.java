package com.alberto.gastos.servicios;

import com.alberto.gastos.entidades.FixedOperation;
import com.alberto.gastos.repositorios.FixedOperationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedOperationService {

    @Autowired
    private FixedOperationJpaRepository fixedOperationJpaRepository;

    public List<FixedOperation> getAll(){
        return fixedOperationJpaRepository.findAll();
    }

    public FixedOperation getById(long codGastoFijo){
        return fixedOperationJpaRepository.findById(codGastoFijo).get();
    }

    public FixedOperation addOperacionFija(FixedOperation fixedOperation){
        return fixedOperationJpaRepository.save(fixedOperation);
    }

    public void deleteOperacionFija(long codOperacionFija){
        fixedOperationJpaRepository.deleteById(codOperacionFija);
    }

}
