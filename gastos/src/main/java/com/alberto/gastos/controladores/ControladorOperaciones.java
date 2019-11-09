package com.alberto.gastos.controladores;

import com.alberto.gastos.entidades.Operacion;
import com.alberto.gastos.servicios.ServicioGastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class ControladorOperaciones {

    @Autowired
    private ServicioGastos servicioGastos;

    @GetMapping
    public List<Operacion> getAllByMonth(@RequestParam int month, @RequestParam int year){
        return servicioGastos.getAllByMonth(month, year);
    }

    @PostMapping
    public Operacion addOperacion(@RequestBody Operacion operacion){
        return servicioGastos.addOperacion(operacion);
    }

    @DeleteMapping("/{codGasto}")
    public void deleteOperacion(@PathVariable("codGasto") long codGasto){
        servicioGastos.deleteOperacion(codGasto);
    }

    @PostMapping("/{codGastoFijo}")
    public Operacion addOperacionByGastoFijoId(@PathVariable("codGastoFijo") long codGastoFijo){
        return servicioGastos.addOperacionByGastoFijoId(codGastoFijo);
    }

}
