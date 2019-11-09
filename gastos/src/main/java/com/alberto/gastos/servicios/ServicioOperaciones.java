package com.alberto.gastos.servicios;

import com.alberto.gastos.entidades.Operacion;
import com.alberto.gastos.entidades.OperacionFija;
import com.alberto.gastos.entidades.TipoGasto;
import com.alberto.gastos.repositorios.OperacionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioOperaciones {

    @Autowired
    private OperacionJpaRepository operacionJpaRepository;

    @Autowired
    private ServicioOperacionesFijas servicioOperacionesFijas;


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
    public Operacion addOperacionByOperacionFijaId(long codOperacionFija){
        OperacionFija operacionFija = servicioOperacionesFijas.getById(codOperacionFija);

        Operacion nuevaOperacion = new Operacion();

        nuevaOperacion.setTxtConcepto(operacionFija.getTxtConcepto());
        nuevaOperacion.setTxtNota(operacionFija.getTxtNota());
        nuevaOperacion.setNumCantidad(operacionFija.getNumCantidad());
        nuevaOperacion.setIndTipo(TipoGasto.FIJO.getCode());
        nuevaOperacion.setDatFecha(LocalDateTime.now());
        nuevaOperacion.setCategoria(operacionFija.getCategoria());

        return operacionJpaRepository.save(nuevaOperacion);
    }


}
