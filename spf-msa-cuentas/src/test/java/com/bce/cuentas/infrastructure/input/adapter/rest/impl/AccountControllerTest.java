package com.bce.cuentas.infrastructure.input.adapter.rest.impl;

import com.bce.cuentas.application.input.port.AccountService;
import com.bce.cuentas.domain.MockData;
import com.bce.cuentas.infrastructure.input.adapter.rest.mapper.AccountMapper;
import com.bce.services.server.models.CuentaDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(value = AccountController.class)
@ExtendWith(MockitoExtension.class)
@ImportAutoConfiguration({
        AccountMapper.class
})
class AccountControllerTest {
    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountMapper accountMapper;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void consultarCuentasTestSucces() {
        when(accountService.getAll())
                .thenReturn(Flux.just(MockData.buildAccountDo()));
        when(accountMapper.toCuentaDto(any()))
                .thenReturn(MockData.buildCuentaDTO());
        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/cuentas").build())
                .exchange()
                .expectStatus().isOk();
                //.expectBody(CuentaDTO.class);
    }
}