package com.alberto.gastos.repositorios;

import com.alberto.gastos.entidades.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationJpaRepository extends JpaRepository<Configuration, Long> {

    Configuration findByNumAnoAndNumMes(int numAno, int numMes);

}
