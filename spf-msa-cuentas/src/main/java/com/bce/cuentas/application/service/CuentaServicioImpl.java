/**
 * 
 */
package com.bce.cuentas.application.service;

import com.nndata.model.Cuenta;
import com.nndata.repository.ICuentaRepo;
import com.nndata.repository.IGenericRepo;
import com.nndata.service.ICuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author edwinleon
 *
 */
@Service
public class CuentaServicioImpl extends CRUDImpl<Cuenta, Long> implements ICuentaServicio {

	@Autowired
	private ICuentaRepo cuentaRepo;

	@Override
	protected IGenericRepo<Cuenta, Long> getRepo() {
		return cuentaRepo;
	}

}
