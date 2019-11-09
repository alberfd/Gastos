package com.alberto.gastos.repositorios;

import com.alberto.gastos.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaJpaRepository extends JpaRepository<Categoria, Long> {
}
