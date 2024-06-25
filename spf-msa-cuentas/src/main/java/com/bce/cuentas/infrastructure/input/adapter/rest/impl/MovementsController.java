package com.bce.cuentas.infrastructure.input.adapter.rest.impl;

import com.bce.cuentas.application.input.port.MovementService;
import com.bce.cuentas.infrastructure.input.adapter.rest.mapper.MovementMapper;
import com.bce.services.server.MovimientosApi;
import com.bce.services.server.models.MovimientoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@Slf4j
public class MovementsController implements MovimientosApi {

    private final MovementService movementService;

    private final MovementMapper movementMapper;

    @Override
    public Mono<ResponseEntity<MovimientoDTO>> crearMovmiento(Mono<MovimientoDTO> movimientoDTO, ServerWebExchange exchange) {
        return movimientoDTO.flatMap(movement -> {
                    final var request = movementMapper.toMovementDo(movement);
                    return movementService.createMovement(request);
                })
                .map(movementDo -> ResponseEntity.ok().body(movementMapper.toMovimientoDto(movementDo)));
    }
/*public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";

    @Autowired
    @Qualifier("modelMapper")
    private ModelMapper mapper;

    @Autowired
    private IMovimientoServicio movimientoServicio;

    @Autowired
    private IMovimientoCuentasServicio movimientoCuentasServicio;

    @GetMapping
    public ResponseEntity<List<MovimientoDto>> listar()  {
        List<MovimientoDto> lista = movimientoServicio.listar().stream().map(p -> mapper.map(p, MovimientoDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDto> listarPorId(@PathVariable("id") Long id)  {
        MovimientoDto dtoResponse;
        Movimiento obj = movimientoServicio.listarPorId(id);

        if (obj == null) {
            throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
        } else {
            dtoResponse = mapper.map(obj, MovimientoDto.class); // PacienteDTO
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovimientoDto> registrar(@Valid @RequestBody MovimientoDto dtoRequest) throws MovimientosException {
        Movimiento p = mapper.map(dtoRequest, Movimiento.class);
        Movimiento obj = movimientoServicio.registrar(p);
        MovimientoDto dtoResponse = mapper.map(obj, MovimientoDto.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<MovimientoDto> modificar(@RequestBody MovimientoDto dtoRequest) throws MovimientosException {
        Movimiento mov = movimientoServicio.listarPorId(dtoRequest.getIdMovimientos());
        if (mov == null) {
            throw new ModeloNotFoundException(ID_NO_ENCONTRADO + dtoRequest.getIdMovimientos());
        }
        Movimiento m = mapper.map(dtoRequest, Movimiento.class);
        Movimiento obj = movimientoServicio.modificar(m);
        MovimientoDto dtoResponse = mapper.map(obj, MovimientoDto.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws MovimientosException {
        Movimiento mov = movimientoServicio.listarPorId(id);

        if (mov == null) {
            throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
        }
        movimientoServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/reporte")
    public ResponseEntity<List<ReporteMovimientosDto>> reporte(@RequestParam String fechaInicio,
                                                               @RequestParam String fechaFin, @RequestParam Long idCliente) {
        List<ReporteMovimientosDto> consultas = movimientoServicio.reporteMovimientos(LocalDate.parse(fechaInicio),
                LocalDate.parse(fechaFin), idCliente);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @PostMapping(value = "/movimientodecuenta")
    public ResponseEntity<MovimientoDto> registrar(@Valid @RequestBody MovimientoDeCuentasDto dtoRequest)
            throws MovimientosException {
        Movimiento obj = movimientoCuentasServicio.validaRegistroMovimiento(dtoRequest);
        MovimientoDto dtoResponse = mapper.map(obj, MovimientoDto.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }*/

}
