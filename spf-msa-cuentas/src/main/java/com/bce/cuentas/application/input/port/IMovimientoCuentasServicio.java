/**
 *
 */
package com.bce.cuentas.application.input.port;


import com.bce.cuentas.domain.MovimientoDeCuentasDto;
import com.bce.cuentas.infrastructure.output.repository.entity.Movimiento;

/**
 * @author edwinleon
 *
 */
public interface IMovimientoCuentasServicio {
    Movimiento validaRegistroMovimiento(MovimientoDeCuentasDto movimientoDeCuentasDto);
}