package com.alberto.gastos.controladores;

import com.alberto.gastos.entidades.OperacionFija;
import com.alberto.gastos.servicios.ServicioOperacionesFijas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operaciones-fijas")
public class ControladorOperacionesFijas {

    @Autowired
    private ServicioOperacionesFijas servicioOperacionesFijas;

    @GetMapping
    public List<OperacionFija> getAll(){
        return servicioOperacionesFijas.getAll();
    }

    @PostMapping
    public OperacionFija addOperacionFija(@RequestBody OperacionFija operacionFija){
        return servicioOperacionesFijas.addOperacionFija(operacionFija);
    }

    @DeleteMapping("/{codGastoFijo}")
    public void deleteOperacionFija(@PathVariable("codOperacionFija") long codOperacionFija){
        servicioOperacionesFijas.deleteOperacionFija(codOperacionFija);
    }

}
