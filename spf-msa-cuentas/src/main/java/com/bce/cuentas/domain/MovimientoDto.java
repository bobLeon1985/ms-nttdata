/**
 * 
 */
package com.bce.cuentas.domain;

import com.nndata.enums.TipoMovimientoEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author edwinleon
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoDto {

	private Long idMovimientos;
	private LocalDateTime fecha;
	private TipoMovimientoEnums tipoMovimiento;
	private BigDecimal valor;
	private BigDecimal saldo;
	private Long idCuenta;
	private String numeroCuenta;
}
