/**
 *
 */
package com.bce.cuentas.application.service;


import com.nndata.dto.ReporteMovimientosDto;
import com.nndata.model.Movimiento;
import com.nndata.repository.IGenericRepo;
import com.nndata.repository.IMovimientoRepo;
import com.nndata.service.IMovimientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author edwinleon
 *
 */
@Service
public class MovimientoServicioImpl extends CRUDImpl<Movimiento, Long> implements IMovimientoServicio {

    @Autowired
    private IMovimientoRepo movimientoRepo;

    @Override
    protected IGenericRepo<Movimiento, Long> getRepo() {
        return movimientoRepo;
    }

    @Override
    public List<ReporteMovimientosDto> reporteMovimientos(LocalDate fechaInicio, LocalDate fechaFin, Long idCliente) {
        List<ReporteMovimientosDto> consultas = new ArrayList<>();
        movimientoRepo.reporteMovimientos(fechaInicio, fechaFin, idCliente).forEach(x -> {
            ReporteMovimientosDto rm = new ReporteMovimientosDto(
                    String.valueOf(x[0]),
                    String.valueOf(x[1]),
                    String.valueOf(x[2]),
                    String.valueOf(x[3]),
                    String.valueOf(x[4]),
                    String.valueOf(x[5]),
                    String.valueOf(x[6]),
                    String.valueOf(x[7]));
            consultas.add(rm);
        });
        return consultas;
    }

    @Override
    public List<Movimiento> buscarMovimientosCuenta(Long idCuenta) {
        return movimientoRepo.findByIdCuenta(idCuenta);
    }


}
