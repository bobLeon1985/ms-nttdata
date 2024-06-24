package com.bce.personas.infrastructure.output.repository.mapper;

import com.bce.personas.domain.ClientDo;
import com.bce.personas.infrastructure.output.repository.entity.Client;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface ClientRepositoryMapper {

    @Mappings({
            @Mapping(target = "password", source = "clientDo.password"),
            @Mapping(target = "personaId", source = "personId"),
            @Mapping(target = "name", ignore = true),
            @Mapping(target = "gender", ignore = true),
            @Mapping(target = "age", ignore = true),
            @Mapping(target = "identification", ignore = true),
            @Mapping(target = "direction", ignore = true),
            @Mapping(target = "phone", ignore = true),
    })
    Client toClient(ClientDo clientDo, Long personId);
}
