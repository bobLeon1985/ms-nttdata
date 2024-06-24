package com.bce.personas.infrastructure.output.repository.repo;

import com.bce.personas.infrastructure.output.repository.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepo extends IGenericRepo<Client, Long> {
}
