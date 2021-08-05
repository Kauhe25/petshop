package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteConsulta;
import br.com.tt.petshop.dto.ClienteConsultaFactory;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.mapper.ClienteMapper;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //Listar todos os clientes
    public List<ClienteListagem> listar(){//TODO trocar iterable
        return clienteRepository.findAll().stream()
                .map(cliente -> ClienteMapper.INSTANCE.converterListagem(cliente))
                .collect(Collectors.toList());
    }

//    private ClienteListagem converterParaListagemDto(Cliente cliente) {
//        //return new ClienteListagem(cliente.getId(), cliente.getNome(), cliente.getCpf());
//    }

    //Buscar clientes por CPF
    public ClienteConsulta buscarPorCpf(String cpf){
        return clienteRepository
                .findByCpf(cpf)
                .map(ClienteMapper.INSTANCE::converterConsulta)
                .orElseThrow();//TODO trocar para exceção específica
    }

    //TODO - Regra: não permitir cadastro de mesmo CPF
    public Long criar(ClienteCriacao criacao){

        Cliente cliente = ClienteMapper.INSTANCE.fromCriacao(criacao);

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo.getId();
    }

    //Update
    public void atualiza(Long id, String nome){
        //Update personalizado no Repository
        // clienteRepository.updateNomeById(id, nome);

        //OU com find + update
        Cliente cliente = clienteRepository.findById(id).orElseThrow();

        if(!cliente.getNome().equalsIgnoreCase(nome)){
            cliente.alterarNome(nome);
            clienteRepository.save(cliente);
        }
    }

    //Delete
    public void apagar(Long id){
        clienteRepository.deleteById(id);
    }

}
