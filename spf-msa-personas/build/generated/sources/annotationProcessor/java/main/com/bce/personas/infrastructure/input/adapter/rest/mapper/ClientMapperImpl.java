package com.bce.personas.infrastructure.input.adapter.rest.mapper;

import com.bce.personas.domain.ClientDo;
import com.bce.personas.infrastructure.output.repository.entity.Client;
import com.bce.personas.infrastructure.output.repository.entity.Person;
import com.bce.services.server.models.ClienteDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDo toClientDo(Client client, Person person) {
        if ( client == null && person == null ) {
            return null;
        }

        ClientDo clientDo = new ClientDo();

        if ( client != null ) {
            if ( client.getId() != null ) {
                clientDo.setId( client.getId() );
            }
            if ( client.getPassword() != null ) {
                clientDo.setPassword( client.getPassword() );
            }
            if ( client.getState() != null ) {
                clientDo.setState( client.getState() );
            }
            if ( client.getClientId() != null ) {
                clientDo.setClientId( client.getClientId() );
            }
        }
        if ( person != null ) {
            if ( person.getName() != null ) {
                clientDo.setName( person.getName() );
            }
            if ( person.getGender() != null ) {
                clientDo.setGender( person.getGender() );
            }
            if ( person.getAge() != null ) {
                clientDo.setAge( person.getAge() );
            }
            if ( person.getIdentification() != null ) {
                clientDo.setIdentification( person.getIdentification() );
            }
            if ( person.getDirection() != null ) {
                clientDo.setDirection( person.getDirection() );
            }
            if ( person.getPhone() != null ) {
                clientDo.setPhone( person.getPhone() );
            }
        }

        return clientDo;
    }

    @Override
    public ClienteDTO toClienteDto(ClientDo clientDo) {
        if ( clientDo == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        if ( clientDo.getName() != null ) {
            clienteDTO.setNombres( clientDo.getName() );
        }
        if ( clientDo.getGender() != null ) {
            clienteDTO.setGenero( clientDo.getGender() );
        }
        if ( clientDo.getAge() != null ) {
            clienteDTO.setEdad( clientDo.getAge() );
        }
        if ( clientDo.getIdentification() != null ) {
            clienteDTO.setIdentificacion( clientDo.getIdentification() );
        }
        if ( clientDo.getDirection() != null ) {
            clienteDTO.setDireccion( clientDo.getDirection() );
        }
        if ( clientDo.getPhone() != null ) {
            clienteDTO.setTelefono( clientDo.getPhone() );
        }
        if ( clientDo.getPassword() != null ) {
            clienteDTO.setContrasenia( clientDo.getPassword() );
        }
        if ( clientDo.getState() != null ) {
            clienteDTO.setEstado( clientDo.getState() );
        }

        return clienteDTO;
    }

    @Override
    public ClientDo toClientDo(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        ClientDo clientDo = new ClientDo();

        if ( clienteDTO.getNombres() != null ) {
            clientDo.setName( clienteDTO.getNombres() );
        }
        if ( clienteDTO.getGenero() != null ) {
            clientDo.setGender( clienteDTO.getGenero() );
        }
        if ( clienteDTO.getEdad() != null ) {
            clientDo.setAge( clienteDTO.getEdad() );
        }
        if ( clienteDTO.getIdentificacion() != null ) {
            clientDo.setIdentification( clienteDTO.getIdentificacion() );
        }
        if ( clienteDTO.getDireccion() != null ) {
            clientDo.setDirection( clienteDTO.getDireccion() );
        }
        if ( clienteDTO.getTelefono() != null ) {
            clientDo.setPhone( clienteDTO.getTelefono() );
        }
        if ( clienteDTO.getContrasenia() != null ) {
            clientDo.setPassword( clienteDTO.getContrasenia() );
        }
        if ( clienteDTO.getEstado() != null ) {
            clientDo.setState( clienteDTO.getEstado() );
        }

        return clientDo;
    }
}
