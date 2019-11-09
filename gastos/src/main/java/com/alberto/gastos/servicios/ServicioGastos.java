package com.alberto.gastos.servicios;

import com.alberto.gastos.entidades.Operacion;
import com.alberto.gastos.entidades.GastoFijo;
import com.alberto.gastos.entidades.TipoGasto;
import com.alberto.gastos.repositorios.OperacionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioGastos {

    @Autowired
    private OperacionJpaRepository operacionJpaRepository;

    @Autowired
    private ServicioGastosFijos servicioGastosFijos;


    public List<Operacion> getAllByMonth(int month, int year){
        return operacionJpaRepository.getAllByMonth(month, year);

    }

    public Operacion addOperacion(Operacion operacion){
        return operacionJpaRepository.save(operacion);
    }

    public void deleteOperacion(long codGasto){
        operacionJpaRepository.deleteById(codGasto);
    }

    @Transactional
    public Operacion addOperacionByGastoFijoId(long codGastoFijo){
        GastoFijo gastoFijo = servicioGastosFijos.getById(codGastoFijo);

        Operacion nuevaOperacion = new Operacion();

        nuevaOperacion.setTxtConcepto(gastoFijo.getTxtConcepto());
        nuevaOperacion.setTxtNota(gastoFijo.getTxtNota());
        nuevaOperacion.setNumCantidad(gastoFijo.getNumCantidad());
        nuevaOperacion.setIndTipo(TipoGasto.FIJO.getCode());
        nuevaOperacion.setDatFecha(LocalDateTime.now());
        nuevaOperacion.setCategorias(new ArrayList<>(gastoFijo.getCategorias()));

        return operacionJpaRepository.save(nuevaOperacion);
    }


}
