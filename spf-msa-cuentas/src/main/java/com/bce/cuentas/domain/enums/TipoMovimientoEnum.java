/**
 * 
 */
package com.bce.cuentas.domain.enums;

import lombok.Getter;

/**
 * @author edwinleon
 *
 */
public enum TipoMovimientoEnum {
	
	R("Retiro"), D("Deposito");

	@Getter
	private String descripcion;

	TipoMovimientoEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
