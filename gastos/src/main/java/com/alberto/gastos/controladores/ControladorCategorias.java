package com.alberto.gastos.controladores;

import com.alberto.gastos.dtos.CategoriaDTO;
import com.alberto.gastos.entidades.Categoria;
import com.alberto.gastos.servicios.ServicioCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class ControladorCategorias {

    @Autowired
    private ServicioCategorias servicioCategorias;

    @GetMapping
    public List<CategoriaDTO> getAllCategories(){


        return servicioCategorias.getAllCategories();
    }

    @PostMapping
    public Categoria addCategory(@RequestBody Categoria categoria){
        return servicioCategorias.addCategory(categoria);
    }

    @PutMapping
    public Categoria updateCategory(@RequestBody Categoria categoria){
        return servicioCategorias.updateCategory(categoria);
    }

}
