package com.bce.personas.application.service;

import com.bce.personas.application.input.port.ClientService;
import com.bce.personas.application.output.port.ClientRepositoryService;
import com.bce.personas.domain.ClientDo;
import com.bce.personas.infrastructure.input.adapter.rest.mapper.ClientMapper;
import com.bce.personas.infrastructure.output.repository.entity.Person;

import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import javax.persistence.Tuple;
import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepositoryService clientRepositoryService;

    private final ClientMapper clientMapper;

    private final DatabaseClient databaseClient;

    @NonNull
    @Override
    public Mono<ClientDo> getClientId(@NotNull Integer id) {
        return clientRepositoryService.getClientId(Long.valueOf(id))
                .map(client -> clientRepositoryService.findByCodPerson(client.getPersonaId())
                        .map(person -> clientMapper.toClientDo(client, person)))
                .flatMap(clientDoMono -> clientDoMono);
    }

    @NonNull
    @Override
    public Mono<ClientDo> create(ClientDo clientDo) {
        return clientRepositoryService.create(clientDo)
                .map(client -> clientRepositoryService.findByCodPerson(client.getPersonaId())
                        .map(person -> clientMapper.toClientDo(client, person)))
                .flatMap(clientDoMono -> clientDoMono);
    }

    @NonNull
    @Override
    public Mono<ClientDo> update(@NotNull Long idClient, @Valid ClientDo clientDo) {
        return clientRepositoryService.getClientId(idClient)
                .flatMap(clientR -> clientRepositoryService.update(clientDo, idClient,clientR.getPersonaId())
                        .flatMap(clientU ->
                                clientRepositoryService.updatePerson(clientDo, clientR.getPersonaId())
                                        .map(person -> Tuples.of(clientU, person))
                        )
                )
                .map(objects -> clientMapper.toClientDo(objects.getT1(), objects.getT2()));
    }

    @NonNull
    @Override
    public Flux<ClientDo> getAll() {
        return clientRepositoryService.getAll()
                .concatMap(client -> clientRepositoryService.findByCodPerson(client.getPersonaId())
                        .map(person -> clientMapper.toClientDo(client, person))
                )
                .doFinally(signalType -> log.info("Get all clients success"));
    }


}
