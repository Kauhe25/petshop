package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.ClienteConsulta;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-19T22:10:15-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class ClienteMapperImpl implements ClienteMapper {

    private final AnimalMapper animalMapper = Mappers.getMapper( AnimalMapper.class );

    @Override
    public ClienteListagem converterListagem(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String cpf = null;

        id = cliente.getId();
        nome = cliente.getNome();
        cpf = cliente.getCpf();

        ClienteListagem clienteListagem = new ClienteListagem( id, nome, cpf );

        return clienteListagem;
    }

    @Override
    public ClienteCriacao converterCriacao(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        String nome = null;
        String cpf = null;

        nome = cliente.getNome();
        cpf = cliente.getCpf();

        ClienteCriacao clienteCriacao = new ClienteCriacao( nome, cpf );

        return clienteCriacao;
    }

    @Override
    public ClienteConsulta converterConsulta(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        List<String> animais = null;
        Long id = null;
        String nome = null;
        String cpf = null;

        animais = animalListToStringList( cliente.getAnimais() );
        id = cliente.getId();
        nome = cliente.getNome();
        cpf = cliente.getCpf();

        ClienteConsulta clienteConsulta = new ClienteConsulta( id, nome, cpf, animais );

        return clienteConsulta;
    }

    @Override
    public Cliente fromCriacao(ClienteCriacao criacao) {
        if ( criacao == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        return cliente;
    }

    protected List<String> animalListToStringList(List<Animal> list) {
        if ( list == null ) {
            return null;
        }

        List<String> list1 = new ArrayList<String>( list.size() );
        for ( Animal animal : list ) {
            list1.add( animalMapper.fromAnimal( animal ) );
        }

        return list1;
    }
}
