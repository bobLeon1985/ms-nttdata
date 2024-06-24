/**
 *
 */
package com.bce.cuentas.infrastructure.output.repository.entity;

import com.bce.cuentas.domain.ClienteDto;
import com.bce.cuentas.domain.enums.TipoCuentaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

/**
 * @author edwinleon
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cuenta")
public class Cuenta {

    @Id

    private Long idCuenta;

    @Column("numero_cuenta")
    private String numeroCuenta;

    @Column("tipo_cuenta")
    private TipoCuentaEnum tipoCuenta;

    @Column("saldo_inicial")
    private BigDecimal saldoInicial;

    @Column("estado")
    private Boolean estado;

    @Column("id_cliente")
    private Integer idCliente;

    @Transient
    private ClienteDto cliente;

}
