/**
 * 
 */
package com.bce.cuentas.infrastructure.output.repository;

import com.bce.cuentas.infrastructure.output.repository.entity.Movimiento;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author edwinleon
 *
 */
public interface IMovimientoRepo extends IGenericRepo<Movimiento, Long> {

	@Query(value = "select m.fecha, c.nombre, cu.numero_cuenta, case when cu.tipo_cuenta = 'C' then 'Corriente' when cu.tipo_cuenta = 'A' then 'Ahorros' end, cu.saldo_inicial, cu.estado, m.valor, m.saldo "
			+ "from cliente c, cuenta cu, movimiento m where c.id = cu.id_cliente "
			+ "and cu.id_cuenta  = m.id_cuenta and m.fecha between (:p1) and (:p2) "
			+ "and c.id = (:p3)")
	List<Object[]> reporteMovimientos(@Param("p1") LocalDate fechaInicio, @Param("p2") LocalDate fechaFin,
			@Param("p3") Long idCliente);
	
	List<Movimiento> findByIdCuenta(Long idCuenta);
	
	

}
