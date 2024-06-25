package com.bce.cuentas.infrastructure.input.adapter.rest.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;

import static org.junit.jupiter.api.Assertions.*;
@WebFluxTest(value = AccountController.class)
@ExtendWith(MockitoExtension.class)
@ImportAutoConfiguration({

})
class AccountControllerTest {

}