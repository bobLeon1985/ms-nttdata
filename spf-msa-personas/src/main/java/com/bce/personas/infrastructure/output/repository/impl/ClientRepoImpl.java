package com.bce.personas.infrastructure.output.repository.impl;

import com.bce.personas.infrastructure.output.repository.entity.Person;
import com.bce.personas.infrastructure.output.repository.repo.IClientRepo;
import com.bce.personas.infrastructure.output.repository.IClientService;
import com.bce.personas.infrastructure.output.repository.repo.IGenericRepo;
import com.bce.personas.infrastructure.output.repository.entity.Client;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientRepoImpl extends CRUDImpl<Client, Long> implements IClientService {

    private final IClientRepo iClientRepo;



    @Override
    protected IGenericRepo<Client, Long> getRepo() {
        return iClientRepo;
    }


}
