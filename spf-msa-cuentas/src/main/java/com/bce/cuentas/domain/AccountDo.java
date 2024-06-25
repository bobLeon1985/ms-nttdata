/**
 *
 */
package com.bce.cuentas.domain;

import com.bce.cuentas.domain.enums.TipoCuentaEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDo {

    private Long idCuenta;

    @Pattern(regexp = "[0-9]*")
    private String accountNumber;

    private TipoCuentaEnum accountType;

    @DecimalMin(value = "0.00")
    private BigDecimal initialBalance;

    private Boolean status;

    private Integer idClient;
    //@JsonIgnore
    //private Cliente cliente;
}
