package com.bce.personas.application.input.port;

import com.bce.personas.domain.ClientDo;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
public interface ClientService {
    @NonNull
    Mono<ClientDo> create(@Valid ClientDo ClientDo);
    @NonNull
    Flux<ClientDo> getAll();
}
