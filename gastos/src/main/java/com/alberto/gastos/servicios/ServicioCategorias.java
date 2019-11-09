package com.alberto.gastos.servicios;

import com.alberto.gastos.dtos.CategoriaDTO;
import com.alberto.gastos.entidades.Categoria;
import com.alberto.gastos.mappers.CategoriaMapper;
import com.alberto.gastos.repositorios.CategoriaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioCategorias {

    @Autowired
    CategoriaJpaRepository categoriaJpaRepository;

    public ServicioCategorias(){

    }

    public List<CategoriaDTO> getAllCategories(){
        List<CategoriaDTO> result = new ArrayList<>();
        List<Categoria> categories = categoriaJpaRepository.findAll();

        for(Categoria category: categories){
            result.add(CategoriaMapper.map(category, true));
        }

        return result;


    }

    public Categoria addCategory(Categoria categoria){
        return categoriaJpaRepository.save(categoria);
    }

    public Categoria updateCategory(Categoria categoria){
        return categoriaJpaRepository.save(categoria);
    }
}
