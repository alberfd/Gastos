package com.alberto.gastos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RowSummaryOperationsDTO {

    private long key;
    private Map<String, Object> data;

    private List<RowSummaryOperationsDTO> children;

}
