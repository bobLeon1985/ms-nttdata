package com.bce.cuentas.infrastructure.input.adapter.rest.config;


import com.bce.cuentas.domain.CuentaDto;
import com.bce.cuentas.infrastructure.output.repository.entity.Cuenta;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("modelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean("cuentaMapper")
    public ModelMapper cuentaMapper(){
        ModelMapper mapper = new ModelMapper();
        TypeMap<CuentaDto, Cuenta> typeMap = mapper.createTypeMap(CuentaDto.class, Cuenta.class);
        typeMap.addMapping(CuentaDto::getIdCliente, (dest, v)-> dest.getCliente().setId((Integer) v));
        return mapper;
    }
}
