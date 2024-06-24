package com.bce.cuentas.application.service;


import com.bce.cuentas.application.input.port.ICRUD;
import com.bce.cuentas.infrastructure.output.repository.IGenericRepo;

import java.util.List;

/**
 * @author edwinleon
 *
 */
public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T registrar(T t) {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t) {
        return getRepo().save(t);
    }

    @Override
    public List<T> listar() {
        return getRepo().findAll();
    }

    @Override
    public T listarPorId(ID id) {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void eliminar(ID id) {
        getRepo().deleteById(id);
    }

}

