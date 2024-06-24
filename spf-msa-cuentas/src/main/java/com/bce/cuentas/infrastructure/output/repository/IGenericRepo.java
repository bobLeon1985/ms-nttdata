/**
 *
 */
package com.bce.cuentas.infrastructure.output.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author edwinleon
 *
 */
public interface IGenericRepo<T, ID> extends ReactiveCrudRepository<T, ID> {

}

