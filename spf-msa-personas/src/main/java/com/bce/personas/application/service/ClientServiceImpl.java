package com.bce.personas.application.service;

import com.bce.personas.application.input.port.ClientService;
import com.bce.personas.application.output.port.ClientRepositoryService;
import com.bce.personas.domain.ClientDo;
import com.bce.personas.infrastructure.input.adapter.rest.mapper.ClientMapper;
import com.bce.personas.infrastructure.output.repository.entity.Person;

import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepositoryService clientRepositoryService;

    private final ClientMapper clientMapper;
    private final DatabaseClient databaseClient;
    private final ConnectionFactory connectionFactory;

    @NonNull
    @Override
    public Mono<ClientDo> create(ClientDo clientDo) {
        return clientRepositoryService.create(clientDo)
                .map(client -> findByCodPerson(client.getPersonaId())
                        .map(person -> clientMapper.toClientDo(client, person)))
                .flatMap(clientDoMono -> clientDoMono);
    }

    @NonNull
    @Override
    public Flux<ClientDo> getAll() {
        return clientRepositoryService.getAll()
                .concatMap(client -> {
                    return findByCodPerson(client.getPersonaId())
                            .map(person -> clientMapper.toClientDo(client, person));
                })
                .map(clientDo -> clientDo);
    }

    private Mono<Person> findByCodPerson(Long idPerson) {
        return databaseClient.sql("SELECT * FROM persona WHERE id =:code")
                .bind("code", idPerson)
                .map(MAPPING_FUNCTION)
                .first();

    }

    public static final BiFunction<Row, RowMetadata, Person> MAPPING_FUNCTION = (row, rowMetaData) -> Person.builder()
            .id(row.get("id", Long.class))
            .name(row.get("nombre", String.class))
            .gender(row.get("genero", String.class))
            .age(row.get("edad", Integer.class))
            .identification(row.get("identificacion", String.class))
            .direction(row.get("direccion", String.class))
            .phone(row.get("telefono", String.class))
            .build();
}
