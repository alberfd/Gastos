package com.alberto.gastos.servicios;

import com.alberto.gastos.entidades.OperacionFija;
import com.alberto.gastos.repositorios.OperacionFijaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioOperacionesFijas {

    @Autowired
    private OperacionFijaJpaRepository operacionFijaJpaRepository;

    public List<OperacionFija> getAll(){
        return operacionFijaJpaRepository.findAll();
    }

    public OperacionFija getById(long codGastoFijo){
        return operacionFijaJpaRepository.findById(codGastoFijo).get();
    }

    public OperacionFija addOperacionFija(OperacionFija operacionFija){
        return operacionFijaJpaRepository.save(operacionFija);
    }

    public void deleteOperacionFija(long codOperacionFija){
        operacionFijaJpaRepository.deleteById(codOperacionFija);
    }

}
