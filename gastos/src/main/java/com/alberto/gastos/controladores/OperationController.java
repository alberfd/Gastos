package com.alberto.gastos.controladores;

import com.alberto.gastos.dtos.OperationDTO;
import com.alberto.gastos.entidades.Operation;
import com.alberto.gastos.servicios.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operaciones")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public List<OperationDTO> getAllByMonth(@RequestParam int month, @RequestParam int year){
        return operationService.getAllByMonth(month, year);
    }

    @PostMapping
    public OperationDTO addOperation(@RequestBody OperationDTO operation){
        return operationService.addOperacion(operation);
    }

    @DeleteMapping("/{codGasto}")
    public void deleteOperation(@PathVariable("codGasto") long codGasto){
        operationService.deleteOperacion(codGasto);
    }

    @PostMapping("/{codGastoFijo}")
    public Operation addOperacionByGastoFijoId(@PathVariable("codGastoFijo") long codGastoFijo){
        return operationService.addOperacionByOperacionFijaId(codGastoFijo);
    }


}
