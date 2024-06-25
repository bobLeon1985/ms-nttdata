package com.bce.cuentas.application.input.port;

import com.bce.cuentas.domain.MovementDo;

import jakarta.validation.Valid;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Validated
public interface MovementService {
    @NonNull
    Mono<MovementDo> createMovement(@Valid MovementDo movementDo);
    //Movements validaRegistroMovimiento(MovimientoDeCuentasDto movimientoDeCuentasDto);
}