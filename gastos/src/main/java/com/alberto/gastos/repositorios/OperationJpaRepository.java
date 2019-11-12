package com.alberto.gastos.repositorios;

import com.alberto.gastos.entidades.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationJpaRepository extends JpaRepository<Operation, Long> {

    @Query(value = "SELECT * FROM OPERACIONES " +
            "WHERE MONTH(DATFECHA) = :month AND YEAR(DATFECHA) = :year",
    nativeQuery = true)
    List<Operation> getAllByMonth(@Param("month") int month, @Param("year") int year);

}
