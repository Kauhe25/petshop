package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.ClienteConsulta;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AnimalMapper.class)
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper( ClienteMapper.class );

    ClienteListagem converterListagem(Cliente cliente);

    ClienteCriacao converterCriacao(Cliente cliente);

    //@Mapping(ignore = true, target = "animais")
    ClienteConsulta converterConsulta(Cliente cliente);

    @Mapping(ignore = true, target="id")
    @Mapping(ignore = true, target="animais")
    Cliente fromCriacao(ClienteCriacao criacao);
}
