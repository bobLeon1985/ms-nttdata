package com.bce.cuentas.application.service;


import com.bce.cuentas.application.input.port.MovementService;
import com.bce.cuentas.application.output.port.AccountRepositoryService;
import com.bce.cuentas.application.output.port.MovementRepositoryService;
import com.bce.cuentas.domain.AccountDo;
import com.bce.cuentas.domain.AccountStateReport;
import com.bce.cuentas.domain.MovementDo;
import com.bce.cuentas.domain.enums.TipoMovimientoEnum;
import com.bce.cuentas.infrastructure.exception.TransactionException;
import com.bce.cuentas.infrastructure.input.adapter.rest.mapper.MovementMapper;
import com.bce.cuentas.infrastructure.output.repository.entity.Account;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovementServiceImpl implements MovementService {

    private final AccountRepositoryService accountRepositoryService;

    private final MovementRepositoryService movementRepositoryService;

    private final MovementMapper movementMapper;

    @NonNull
    @Override
    public Mono<MovementDo> createMovement(@Valid MovementDo movementDo) {
        return accountRepositoryService.getAccountById(movementDo.getIdCuenta().longValue())
                .flatMap(accountDo -> {

                    if (TipoMovimientoEnum.D.getDescripcion().equals(movementDo.getTipoMovimiento().getDescripcion()) && movementDo.getValor().compareTo(BigDecimal.ZERO) >= 0) {
                        depositMoney(accountDo, movementDo);
                    } else if (TipoMovimientoEnum.R.getDescripcion().equals(movementDo.getTipoMovimiento().getDescripcion()) && movementDo.getValor().compareTo(BigDecimal.ZERO) <= 0) {
                        withdrawMoney(accountDo, movementDo);
                    } else
                        return Mono.error(new TransactionException("Tipo de transacción no valida"));

                    return accountRepositoryService.postAccount(accountDo)
                            .thenReturn(accountDo)
                            .flatMap(request -> {
                                log.info("Movimiento");
                                return movementRepositoryService.addTransaction(movementDo, accountDo.getInitialBalance())
                                        .map(movementMapper::toMovementDo);
                            });

                });
    }

    @NonNull
    @Override
    public Flux<MovementDo> getAll() {
        return movementRepositoryService.getAll()
                .map(movementMapper::toMovementDo);

    }

    @NonNull
    @Override
    public Flux<AccountStateReport> reportXUserAndDate(String identification) {
        return movementRepositoryService.reportXUserAndDate(identification);
    }


    private void depositMoney(AccountDo account, MovementDo transaction) {
        account.setInitialBalance(account.getInitialBalance().add(transaction.getValor()));
    }

    private void withdrawMoney(AccountDo account, MovementDo transaction) {
        if (account.getInitialBalance().add(transaction.getValor()).intValue() < 0) {
            throw new TransactionException("Saldo no disponible");
        }
        account.setInitialBalance(account.getInitialBalance().add(transaction.getValor()));
    }

}
