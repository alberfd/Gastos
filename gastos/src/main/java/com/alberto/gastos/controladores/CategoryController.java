package com.alberto.gastos.controladores;

import com.alberto.gastos.dtos.CategoryDTO;
import com.alberto.gastos.entidades.Category;
import com.alberto.gastos.servicios.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategories(){


        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

}
