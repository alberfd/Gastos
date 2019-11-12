package com.alberto.gastos.repositorios;

import com.alberto.gastos.entidades.FixedOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedOperationJpaRepository extends JpaRepository<FixedOperation, Long> {
}
