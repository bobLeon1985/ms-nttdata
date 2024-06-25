package com.bce.cuentas.infrastructure.input.adapter.rest.impl;

import com.bce.cuentas.application.input.port.AccountService;
import com.bce.cuentas.infrastructure.input.adapter.rest.mapper.AccountMapper;
import com.bce.services.server.CuentasApi;
import com.bce.services.server.models.CuentaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AccountController implements CuentasApi {

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    @Override
    public Mono<ResponseEntity<Flux<CuentaDTO>>> consultarCuentas(ServerWebExchange exchange) {
        return accountService.getAll()
                .map(accountMapper::toCuentaDto)
                .collectList()
                .map(Flux::fromIterable)
                .map(accountDo -> ResponseEntity.ok().body(accountDo));
    }

    @Override
    public Mono<ResponseEntity<Void>> crearCuenta(Mono<CuentaDTO> cuentaDTO, ServerWebExchange exchange) {
        return cuentaDTO.flatMap(account -> accountService.postAccount(accountMapper.toAccountDo(account)))
                .map(response -> ResponseEntity.ok().build());
    }

    /*
    @GetMapping
    public ResponseEntity<List<CuentaDto>> listar() throws Exception {
        List<CuentaDto> lista = cuentaServicio.listar().stream().map(p -> mapper.map(p, CuentaDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CuentaDto> listarPorId(@PathVariable("id") Long id) throws Exception {
        CuentaDto dtoResponse;
        Cuenta obj = cuentaServicio.listarPorId(id);

        if (obj == null) {
            throw new ModeloNotFoundException(ID_NO_ENCONTRADO+ id);
        } else {
            dtoResponse = mapper.map(obj, CuentaDto.class); // PacienteDTO
        }

        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CuentaDto> registrar(@Valid @RequestBody CuentaDto dtoRequest) throws Exception{
        Cuenta c = mapper.map(dtoRequest, Cuenta.class);
        Cuenta obj = cuentaServicio.registrar(c);
        CuentaDto dtoResponse = mapper.map(obj, CuentaDto.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<CuentaDto> modificar(@RequestBody CuentaDto dtoRequest) throws Exception {
        Cuenta cuenta = cuentaServicio.listarPorId(dtoRequest.getIdCuenta());

        if (cuenta == null) {
            throw new ModeloNotFoundException(ID_NO_ENCONTRADO+ dtoRequest.getNumeroCuenta());
        }
        Cuenta c = mapper.map(dtoRequest, Cuenta.class);

        Cuenta obj = cuentaServicio.modificar(c);

        CuentaDto dtoResponse = mapper.map(obj, CuentaDto.class);

        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception {
        Cuenta cuenta = cuentaServicio.listarPorId(id);

        if (cuenta == null) {
            throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
        }
        cuentaServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

}
