package com.alberto.gastos.repositorios;

import com.alberto.gastos.entidades.GastoFijo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoFijoJpaRepository extends JpaRepository<GastoFijo, Long> {
}
