package com.bce.cuentas.infrastructure.input.adapter.rest.impl;


import com.bce.cuentas.application.input.port.IMovimientoCuentasServicio;
import com.bce.cuentas.application.input.port.IMovimientoServicio;
import com.bce.cuentas.domain.MovimientoDto;
import com.bce.cuentas.infrastructure.output.repository.entity.Movimiento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author edwinleon
 *
 */
@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

	public static final String ID_NO_ENCONTRADO = "ID NO ENCONTRADO ";

	@Autowired
	@Qualifier("modelMapper")
	private ModelMapper mapper;

	@Autowired
	private IMovimientoServicio movimientoServicio;

	@Autowired
	private IMovimientoCuentasServicio movimientoCuentasServicio;

	/**
	 * Obtiene la lista de Movimientoss
	 * 
	 * @return -dto de Movimientoss
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<MovimientoDto>> listar()  {
		List<MovimientoDto> lista = movimientoServicio.listar().stream().map(p -> mapper.map(p, MovimientoDto.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	/**
	 * Lista por identificador de Movimientos
	 * 
	 * @param id identificador del Movimientos
	 * @return Dto de Movimientos
	 * @throws Exception
	 */
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

	/**
	 * Registra el Movimientos
	 * 
	 * @param dtoRequest dto del Movimientos
	 * @return Movimientos dto
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<MovimientoDto> registrar(@Valid @RequestBody MovimientoDto dtoRequest) throws MovimientosException {
		Movimiento p = mapper.map(dtoRequest, Movimiento.class);
		Movimiento obj = movimientoServicio.registrar(p);
		MovimientoDto dtoResponse = mapper.map(obj, MovimientoDto.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
	}

	/**
	 * Modifica el Movimientos
	 * 
	 * @param dtoRequest deto de Movimientos
	 * @return dto de Movimientos modificado
	 * @throws Exception
	 */
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

	/**
	 * Elimina Movimientos por id
	 * 
	 * @param id identificador del Movimientos
	 * @return retorna vacio
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws MovimientosException {
		Movimiento mov = movimientoServicio.listarPorId(id);

		if (mov == null) {
			throw new ModeloNotFoundException(ID_NO_ENCONTRADO + id);
		}
		movimientoServicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Lista de Reportes por movimiento
	 * @param fechaInicio fecha incio
	 * @param fechaFin fecha Fin
	 * @param idCliente id del Cliente
	 * @return lista de movimientos
	 */
	@GetMapping(value = "/reporte")
	public ResponseEntity<List<ReporteMovimientosDto>> reporte(@RequestParam String fechaInicio,
															   @RequestParam String fechaFin, @RequestParam Long idCliente) {
		List<ReporteMovimientosDto> consultas = movimientoServicio.reporteMovimientos(LocalDate.parse(fechaInicio),
				LocalDate.parse(fechaFin), idCliente);
		return new ResponseEntity<>(consultas, HttpStatus.OK);
	}

	/**
	 * Registra el movimientos validado
	 * @param dtoRequest que recibe id Cuenta, valor, tipo de tx
	 * @return el movimiento registrado
	 * @throws Exception
	 */
	@PostMapping(value = "/movimientodecuenta")
	public ResponseEntity<MovimientoDto> registrar(@Valid @RequestBody MovimientoDeCuentasDto dtoRequest)
			throws MovimientosException {
		Movimiento obj = movimientoCuentasServicio.validaRegistroMovimiento(dtoRequest);
		MovimientoDto dtoResponse = mapper.map(obj, MovimientoDto.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
	}

}
