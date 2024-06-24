package com.bce.cuentas.infrastructure.input.adapter.rest.impl;

import com.bce.cuentas.application.input.port.ICuentaServicio;
import com.bce.cuentas.domain.CuentaDto;
import com.bce.cuentas.infrastructure.output.repository.entity.Cuenta;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
package com.nndata.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author edwinleon
 *
 */
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Slf4j
public class CuentaController {

    public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";

    @Autowired
    @Qualifier("cuentaMapper")
    private ModelMapper mapper;

    @Autowired
    private final ICuentaServicio cuentaServicio;

    /**
     * Obtiene la lista de Cuentas
     *
     * @return -dto de Cuentas
     * @throws Exception
     */
    @GetMapping
    public ResponseEntity<List<CuentaDto>> listar() throws Exception {
        List<CuentaDto> lista = cuentaServicio.listar().stream().map(p -> mapper.map(p, CuentaDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    /**
     * Lista por identificador de Cuenta
     *
     * @param id identificador del Cuenta
     * @return Dto de Cuenta
     * @throws Exception
     */
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

    /**
     * Registra el Cuenta
     *
     * @param dtoRequest dto del Cuenta
     * @return Cuenta dto
     * @throws Exception
     */
    @PostMapping
    public ResponseEntity<CuentaDto> registrar(@Valid @RequestBody CuentaDto dtoRequest) throws Exception{
        Cuenta c = mapper.map(dtoRequest, Cuenta.class);
        Cuenta obj = cuentaServicio.registrar(c);
        CuentaDto dtoResponse = mapper.map(obj, CuentaDto.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }

    /**
     * Modifica el Cuenta
     *
     * @param dtoRequest deto de Cuenta
     * @return dto de Cuenta modificado
     * @throws Exception
     */
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

    /**
     * Elimina Cuenta por id
     *
     * @param id identificador del Cuenta
     * @return retorna vacio
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception {
        Cuenta cuenta = cuentaServicio.listarPorId(id);

        if (cuenta == null) {
            throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
        }
        cuentaServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
