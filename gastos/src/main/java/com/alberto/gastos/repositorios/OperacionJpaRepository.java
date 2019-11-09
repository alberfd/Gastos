package com.alberto.gastos.repositorios;

import com.alberto.gastos.entidades.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperacionJpaRepository extends JpaRepository<Operacion, Long> {

    @Query(value = "SELECT * FROM GASTOS " +
            "WHERE MONTH(DATFECHA) = :month AND YEAR(DATFECHA) = :year",
    nativeQuery = true)
    List<Operacion> getAllByMonth(@Param("month") int month, @Param("year") int year);

}
