package com.alberto.gastos.servicios;

import com.alberto.gastos.dtos.CategoryDTO;
import com.alberto.gastos.dtos.RowSummaryOperationsDTO;
import com.alberto.gastos.dtos.OperationDTO;
import com.alberto.gastos.dtos.SummaryMonthDTO;
import com.alberto.gastos.entidades.Configuration;
import com.alberto.gastos.entidades.Operation;
import com.alberto.gastos.entidades.OperationType;
import com.alberto.gastos.mappers.ConfigurationMapper;
import com.alberto.gastos.repositorios.ConfigurationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
public class SummaryService {

    @Autowired
    private OperationService operationService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ConfigurationJpaRepository configurationJpaRepository;

    public SummaryMonthDTO getSummaryByMonth(int month, int year){

        List<OperationDTO> operations = operationService.getAllByMonth(month, year);
        List<CategoryDTO> categorias = categoryService.getAllCategories();
        Configuration configuration = configurationJpaRepository.findByNumAnoAndNumMes(year, month);

        SummaryMonthDTO result = new SummaryMonthDTO();

        List<RowSummaryOperationsDTO> treeData = getTreeDataOperations(operations, categorias);

        result.setOperaciones(treeData);
        result.setConfiguracion(ConfigurationMapper.map(configuration));
        result.setTotalGastos(getTotalExpenditureOperations(operations));
        result.setDisponibleDiario(calculateDayAvaiableAmount(operations, configuration));

        return result;


    }

    private float calculateDayAvaiableAmount(List<OperationDTO> operations, Configuration configuration){
        float totalExpenditure = getTotalExpenditureOperations(operations);
        int numDaysUntilEndMonth = calculateNumDaysUntilEndOfMonth();

        return (configuration.getNumCantidadInicial() - totalExpenditure -configuration.getNumAhorroDeseado())
                / calculateNumDaysUntilEndOfMonth();
    }

    private int calculateNumDaysUntilEndOfMonth(){
        LocalDate now = LocalDate.now(); //2015-11-23
        LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());

        return lastDay.getDayOfMonth() - now.getDayOfMonth();
    }

    private float getTotalExpenditureOperations(List<OperationDTO> operations){

        float total = 0;

        for(OperationDTO operation: operations){
            OperationType operationType = OperationType.fromCode(operation.getTipoOperacion().getCode());

            if(operationType == OperationType.GASTO_FIJO || operationType == OperationType.GASTO_VARIABLE){
                total += operation.getNumCantidad();
            }else{
                total -= operation.getNumCantidad();
            }
        }

        return total;
    }

    private List<RowSummaryOperationsDTO> getTreeDataOperations(List<OperationDTO> operations,
                                                                List<CategoryDTO> allCategories){

        List<RowSummaryOperationsDTO> result = new ArrayList<>();

        for(CategoryDTO fatherCategory: this.getParentCategories(allCategories)){

            RowSummaryOperationsDTO fila = this.processCategory(fatherCategory, operations, allCategories);

            result.add(fila);
            
        }

        return result;

    }

    private RowSummaryOperationsDTO processCategory(CategoryDTO category, List<OperationDTO> operations,
                                                    List<CategoryDTO> allCategories){

        RowSummaryOperationsDTO result = new RowSummaryOperationsDTO();

        result.setKey(category.getCodCategoria());
        HashMap<String, Object> data = new HashMap<>();

        data.put("nombre", category.getTxtNombre());
        data.put("total", this.calculateTotalByCategory(category, operations, allCategories));
        data.put("tipo", "categoria");

        result.setData(data);

        List<RowSummaryOperationsDTO> children = new ArrayList<>();

        for(CategoryDTO categoryDTO: this.getDirectChildrenCategories(category, allCategories)){
            children.add(this.processCategory(categoryDTO, operations, allCategories));
        }

        children.addAll(this.getRowOperationsCategory(category, operations));

        result.setChildren(children);

        return result;
    }

    private List<CategoryDTO> getDirectChildrenCategories(CategoryDTO categoryDTO, List<CategoryDTO> allCategories){
        List<CategoryDTO> result = new ArrayList<>();

        for(CategoryDTO categoryDTO1: allCategories){
            if(categoryDTO1.getCategoriaPadre() != null &&
                    categoryDTO1.getCategoriaPadre().getCodCategoria() == categoryDTO.getCodCategoria()){
                result.add(categoryDTO1);
            }
        }

        return result;
    }

    private List<CategoryDTO> getAllSubcategories(CategoryDTO categoryDTO, List<CategoryDTO> allCategories){
        List<CategoryDTO> result = new ArrayList<>();

        for(CategoryDTO category: getDirectChildrenCategories(categoryDTO, allCategories)){
            result.add(category);
            result.addAll(getAllSubcategories(category, allCategories));
        }

        result.add(categoryDTO);

        return result;
    }

    private float calculateTotalByCategory(CategoryDTO categoryDTO, List<OperationDTO> operations,
                                           List<CategoryDTO> allCategories){
        List<CategoryDTO> allSubcategories = new ArrayList<>();
        float result = 0;

        allSubcategories.addAll(this.getAllSubcategories(categoryDTO, allCategories));

        for(OperationDTO operationDTO: operations){
            if(allSubcategories.contains(operationDTO.getCategoria())){
                result += operationDTO.getNumCantidad();
            }
        }

        return result;


    }

    private List<RowSummaryOperationsDTO> getRowOperationsCategory(CategoryDTO category, List<OperationDTO> operations){

        List<OperationDTO> operationsDTO = this.getDirectOperationsFromCategory(category, operations);
        List<RowSummaryOperationsDTO> result = new ArrayList<>();

        for(OperationDTO operationDTO: operationsDTO){
            RowSummaryOperationsDTO rowSummaryOperationsDTO = new RowSummaryOperationsDTO();

            rowSummaryOperationsDTO.setKey(operationDTO.getCodOperacion());

            Map<String, Object> data = new HashMap<>();

            data.put("nombre", operationDTO.getTxtConcepto());
            data.put("total", operationDTO.getNumCantidad());
            data.put("tipo", "operation");

            rowSummaryOperationsDTO.setData(data);

            result.add(rowSummaryOperationsDTO);

        }

        return result;
    }

    private List<OperationDTO> getDirectOperationsFromCategory(CategoryDTO category, List<OperationDTO> operations){
        List<OperationDTO> result = new ArrayList<>();

        for(OperationDTO operationDTO: operations){
            if(operationDTO.getCategoria().getCodCategoria() == category.getCodCategoria())
                result.add(operationDTO);
        }

        return result;
    }


    private List<CategoryDTO> getParentCategories(List<CategoryDTO> categories){
        List<CategoryDTO> result = new ArrayList<>();
        for(CategoryDTO categoryDTO: categories){
            if(categoryDTO.getCategoriaPadre() == null){
                result.add(categoryDTO);
            }
        }

        return result;
    }

}
