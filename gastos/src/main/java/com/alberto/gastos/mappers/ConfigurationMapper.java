package com.alberto.gastos.mappers;

import com.alberto.gastos.dtos.ConfigurationDTO;
import com.alberto.gastos.entidades.Configuration;

public class ConfigurationMapper {


    public static ConfigurationDTO map(Configuration configuration){
        ConfigurationDTO result = new ConfigurationDTO();

        result.setCodConfiguracion(configuration.getCodConfiguracion());
        result.setNumAhorroDeseado(configuration.getNumAhorroDeseado());
        result.setNumCantidadInicial(configuration.getNumCantidadInicial());
        result.setNumAno(configuration.getNumAno());
        result.setNumMes(configuration.getNumMes());

        return result;
    }

}
