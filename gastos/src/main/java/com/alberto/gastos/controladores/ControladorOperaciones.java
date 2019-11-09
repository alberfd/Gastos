package com.alberto.gastos.controladores;

import com.alberto.gastos.entidades.Operacion;
import com.alberto.gastos.servicios.ServicioOperaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operaciones")
public class ControladorOperaciones {

    @Autowired
    private ServicioOperaciones servicioOperaciones;

    @GetMapping
    public List<Operacion> getAllByMonth(@RequestParam int month, @RequestParam int year){
        return servicioOperaciones.getAllByMonth(month, year);
    }

    @PostMapping
    public Operacion addOperacion(@RequestBody Operacion operacion){
        return servicioOperaciones.addOperacion(operacion);
    }

    @DeleteMapping("/{codGasto}")
    public void deleteOperacion(@PathVariable("codGasto") long codGasto){
        servicioOperaciones.deleteOperacion(codGasto);
    }

    @PostMapping("/{codGastoFijo}")
    public Operacion addOperacionByGastoFijoId(@PathVariable("codGastoFijo") long codGastoFijo){
        return servicioOperaciones.addOperacionByOperacionFijaId(codGastoFijo);
    }


}
