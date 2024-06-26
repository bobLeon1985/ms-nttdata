package com.bce.cuentas.infrastructure.output.repository;

import com.bce.cuentas.domain.AccountStateReport;
import com.bce.cuentas.infrastructure.output.repository.entity.Movements;
import com.bce.cuentas.infrastructure.output.repository.repo.IGenericRepo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IMovimientoRepo extends IGenericRepo<Movements, Long> {

    @Query("SELECT M.FECHA, P.nombre  AS CLIENTE, C.NUMERO_CUENTA, C.TIPO_MOVIMIENTO AS TIPO, M.saldo , M.VALOR AS MOVIMIENTO, M.SALDO AS SALDO_DISPONIBLE, 'true' ESTADO \n" +
            "FROM MOVIMIENTOS M \n" +
            "  INNER JOIN CUENTA C ON M.id_cuenta  = C.id_cuenta  \n" +
            "  INNER JOIN CLIENTE C2 ON C2.cliente_id  = C.cliente_id  \n" +
            "  INNER JOIN PERSONA P ON P.id  = C2.persona_id  \n" +
            "  WHERE P.IDENTIFICACION = :identificacion")
    Flux<AccountStateReport> findEstadoCuentaByFechas(String identificacion);

}
