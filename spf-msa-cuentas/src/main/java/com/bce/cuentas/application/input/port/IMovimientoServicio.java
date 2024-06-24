/**
 * 
 */
package com.bce.cuentas.application.input.port;



import com.nndata.dto.ReporteMovimientosDto;
import com.nndata.model.Movimiento;

import java.time.LocalDate;
import java.util.List;

/**
 * @author edwinleon
 *
 */
public interface IMovimientoServicio extends ICRUD<Movimiento, Long> {
	
	List<ReporteMovimientosDto> reporteMovimientos(LocalDate fechaInicio, LocalDate fechaFin, Long idCliente);
	
	List<Movimiento> buscarMovimientosCuenta(Long idCuenta);
}
