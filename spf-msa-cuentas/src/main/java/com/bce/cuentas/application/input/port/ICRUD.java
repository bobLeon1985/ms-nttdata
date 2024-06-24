/**
 *
 */

package com.bce.cuentas.application.input.port;


import java.util.List;

/**
 * @author edwinleon
 *
 */
public interface ICRUD<T, ID> {

    T registrar(T t);

    T modificar(T t);

    List<T> listar();

    T listarPorId(ID id);

    void eliminar(ID id);
}
