package com.alberto.gastos.controladores;

import com.alberto.gastos.entidades.GastoFijo;
import com.alberto.gastos.servicios.ServicioGastosFijos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos-fijos")
public class ControladorGastosFijos {

    @Autowired
    private ServicioGastosFijos servicioGastosFijos;

    @GetMapping
    public List<GastoFijo> getAll(){
        return servicioGastosFijos.getAll();
    }

    @PostMapping
    public GastoFijo addGastoFijo(@RequestBody GastoFijo gastoFijo){
        return servicioGastosFijos.addGastoFijo(gastoFijo);
    }

    @DeleteMapping("/{codGastoFijo}")
    public void deleteGastoFijo(@PathVariable("codGastoFijo") long codGastoFijo){
        servicioGastosFijos.deleteGastoFijo(codGastoFijo);
    }

}
