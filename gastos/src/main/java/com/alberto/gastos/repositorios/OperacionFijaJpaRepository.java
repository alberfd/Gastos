package com.alberto.gastos.repositorios;

import com.alberto.gastos.entidades.OperacionFija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacionFijaJpaRepository extends JpaRepository<OperacionFija, Long> {
}
