package com.bce.personas.application.output.port;

import com.bce.personas.domain.ClientDo;
import com.bce.personas.infrastructure.output.repository.entity.Client;
import com.bce.personas.infrastructure.output.repository.entity.Person;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
public interface ClientRepositoryService {
    @NonNull
    Flux<Client> getAll();

    @NonNull
    Mono<Client> create(ClientDo clientDo);

    //Mono<Client> update(ClientDo clientDo);
}
