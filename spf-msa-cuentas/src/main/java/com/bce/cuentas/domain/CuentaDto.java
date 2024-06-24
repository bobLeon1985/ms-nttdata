/**
 *
 */
package com.bce.cuentas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nndata.enums.TipoCuentaEnum;
import com.nndata.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author edwinleon
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CuentaDto {
    private Long idCuenta;
    private Integer idCliente;
    private String numeroCuenta;
    private TipoCuentaEnum tipoCuenta;
    private BigDecimal saldoInicial;
    private Boolean estado;
    @JsonIgnore
    private Cliente cliente;
}
