package com.alberto.gastos.repositorios;

import com.alberto.gastos.entidades.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
}
