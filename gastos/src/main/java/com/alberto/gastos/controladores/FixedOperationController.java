package com.alberto.gastos.controladores;

import com.alberto.gastos.entidades.FixedOperation;
import com.alberto.gastos.servicios.FixedOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operaciones-fijas")
public class FixedOperationController {

    @Autowired
    private FixedOperationService fixedOperationService;

    @GetMapping
    public List<FixedOperation> getAll(){
        return fixedOperationService.getAll();
    }

    @PostMapping
    public FixedOperation addOperacionFija(@RequestBody FixedOperation fixedOperation){
        return fixedOperationService.addOperacionFija(fixedOperation);
    }

    @DeleteMapping("/{codGastoFijo}")
    public void deleteOperacionFija(@PathVariable("codOperacionFija") long codOperacionFija){
        fixedOperationService.deleteOperacionFija(codOperacionFija);
    }

}
