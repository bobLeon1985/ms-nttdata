package com.bce.cuentas.infrastructure.input.adapter.rest.mapper;

import com.bce.cuentas.domain.MovementDo;
import com.bce.cuentas.domain.enums.TipoCuentaEnum;
import com.bce.cuentas.domain.enums.TipoMovimientoEnum;
import com.bce.cuentas.infrastructure.output.repository.entity.Movements;
import com.bce.services.server.models.MovimientoDTO;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface MovementMapper {

    @Mappings({
            @Mapping(target = "idCuenta",source = "cuentaId")
    })
    MovementDo toMovementDo(MovimientoDTO movimientoDTO);


    MovimientoDTO toMovimientoDto(MovementDo movementDo);

    default TipoMovimientoEnum map(String value) {
        return TipoMovimientoEnum.valueOf(value);
    }

    /*@Mappings({
            @Mapping(target = "",source = "")
    })*/
    MovementDo toMovementDo (Movements movements);
}
