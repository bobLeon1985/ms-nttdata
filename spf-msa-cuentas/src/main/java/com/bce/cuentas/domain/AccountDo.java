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
    String accountNumber;

    TipoCuentaEnum accountType;

    @DecimalMin(value = "0.00")
    BigDecimal initialBalance;

    Boolean status;

    Integer idClient;
    //@JsonIgnore
    //private Cliente cliente;
}
