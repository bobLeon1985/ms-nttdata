package com.bce.personas.infrastructure.output.repository.mapper;

import com.bce.personas.domain.ClientDo;
import com.bce.personas.infrastructure.output.repository.entity.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ClientRepositoryMapperImpl implements ClientRepositoryMapper {

    @Override
    public Client toClient(ClientDo clientDo, Long personId) {
        if ( clientDo == null && personId == null ) {
            return null;
        }

        Client client = new Client();

        if ( clientDo != null ) {
            if ( clientDo.getPassword() != null ) {
                client.setPassword( clientDo.getPassword() );
            }
            if ( clientDo.getId() != null ) {
                client.setId( clientDo.getId() );
            }
            if ( clientDo.getClientId() != null ) {
                client.setClientId( clientDo.getClientId() );
            }
            if ( clientDo.getState() != null ) {
                client.setState( clientDo.getState() );
            }
        }
        if ( personId != null ) {
            client.setPersonaId( personId );
        }

        return client;
    }
}
