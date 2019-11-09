package com.alberto.gastos.servicios;

import com.alberto.gastos.entidades.GastoFijo;
import com.alberto.gastos.repositorios.GastoFijoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioGastosFijos {

    @Autowired
    private GastoFijoJpaRepository gastoFijoJpaRepository;

    public List<GastoFijo> getAll(){
        return gastoFijoJpaRepository.findAll();
    }

    public GastoFijo getById(long codGastoFijo){
        return gastoFijoJpaRepository.findById(codGastoFijo).get();
    }

    public GastoFijo addGastoFijo(GastoFijo gastoFijo){
        return gastoFijoJpaRepository.save(gastoFijo);
    }

    public void deleteGastoFijo(long codGastoFijo){
        gastoFijoJpaRepository.deleteById(codGastoFijo);
    }

}
