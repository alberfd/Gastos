package com.alberto.gastos.servicios;

import com.alberto.gastos.dtos.CategoryDTO;
import com.alberto.gastos.entidades.Category;
import com.alberto.gastos.mappers.CategoryMapper;
import com.alberto.gastos.repositorios.CategoryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    public CategoryService(){

    }

    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> result = new ArrayList<>();
        List<Category> categories = categoryJpaRepository.findAll();

        for(Category category: categories){
            result.add(CategoryMapper.map(category, true));
        }

        return result;


    }

    public Category addCategory(Category category){
        return categoryJpaRepository.save(category);
    }

    public Category updateCategory(Category category){
        return categoryJpaRepository.save(category);
    }
}
