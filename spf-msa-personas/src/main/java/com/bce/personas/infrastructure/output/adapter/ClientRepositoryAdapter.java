package com.bce.personas.infrastructure.output.adapter;

import com.bce.personas.application.output.port.ClientRepositoryService;
import com.bce.personas.domain.ClientDo;
import com.bce.personas.infrastructure.exception.ClientNotFoundException;
import com.bce.personas.infrastructure.exception.DatabaseSavingOperationException;
import com.bce.personas.infrastructure.output.repository.IClientService;
import com.bce.personas.infrastructure.output.repository.entity.Client;
import com.bce.personas.infrastructure.output.repository.entity.Person;
import com.bce.personas.infrastructure.output.repository.impl.ClientRepoImpl;
import com.bce.personas.infrastructure.output.repository.mapper.ClientRepositoryMapper;
import com.bce.personas.infrastructure.output.repository.repo.IClientRepo;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientRepositoryAdapter implements ClientRepositoryService {

    private final IClientService iClientService;

    private final ClientRepositoryMapper clientRepositoryMapper;

    private final DatabaseClient databaseClient; //TODO: artilugio para trabajar con entidad extends

    private final ConnectionFactory connectionFactory;

    @NonNull
    @Override
    public Mono<Client> getClientId(Long id) {
        return iClientService.getById(id)
                .switchIfEmpty(Mono.error(ClientNotFoundException::new));
    }

    @NonNull
    @Override
    public Flux<Client> getAll() {
        return iClientService.getAll();
    }

    @NonNull
    @Override
    public Mono<Client> create(ClientDo client) {
        return customPerson(client)
                .flatMap(person -> iClientService.registrar(clientRepositoryMapper.toClient(client, person)))
                .map(response -> response);

    }

    public Mono<Long> customPerson(ClientDo client) {
        return databaseClient.sql("INSERT INTO  persona (nombre, genero,edad,identificacion,direccion,telefono) VALUES (:nombre, :genero, :edad, :identificacion,:direccion,:telefono)")
                .filter((statement, executeFunction) -> statement.returnGeneratedValues("id").execute())
                .bind("nombre", client.getName())
                .bind("genero", client.getGender())
                .bind("edad", client.getAge())
                .bind("identificacion", client.getIdentification())
                .bind("direccion", client.getDirection())
                .bind("telefono", client.getPhone())
                .fetch()
                .first()
                .map(r -> (Long) r.get("id"))
                .doOnError(throwable -> log.info("Error register client ={}", throwable.getMessage()))
                .onErrorMap(throwable -> new DatabaseSavingOperationException());

    }

}
