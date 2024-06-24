/**
 *
 */
package com.bce.cuentas.infrastructure.output.repository.entity;


import com.bce.cuentas.domain.enums.TipoMovimientoEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author edwinleon
 *
 */
@Data
@Table(name = "movimiento")
public class Movimiento {

    @Id
    private Long idMovimientos;

    @Column("fecha")
    private LocalDateTime fecha;

    @Column("tipo_movimiento")
    private TipoMovimientoEnum tipoMovimiento;

    @Column("valor")
    private BigDecimal valor;

    @Column("saldo")
    private BigDecimal saldo;

    @Column("numero_cuenta")
    private String numeroCuenta;

    @Column("id_cuenta")
    private Long idCuenta;

    @Transient
    private Cuenta cuenta;


}
