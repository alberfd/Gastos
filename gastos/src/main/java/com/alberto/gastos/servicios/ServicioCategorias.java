package com.alberto.gastos.servicios;

import com.alberto.gastos.entidades.Categoria;
import com.alberto.gastos.repositorios.CategoriaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCategorias {

    @Autowired
    CategoriaJpaRepository categoriaJpaRepository;

    public ServicioCategorias(){

    }

    public List<Categoria> getAllCategories(){
        return categoriaJpaRepository.findAll();
    }

    public Categoria addCategory(Categoria categoria){
        return categoriaJpaRepository.save(categoria);
    }

    public Categoria updateCategory(Categoria categoria){
        return categoriaJpaRepository.save(categoria);
    }
}
