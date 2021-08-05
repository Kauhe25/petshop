package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Java6Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    ClienteService clienteService;

    @Test
    void deveListarClientesListaVazia() {
        when(clienteRepository.findAll()).thenReturn(List.of());

        //Ação!
        List<ClienteListagem> clientes = clienteService.listar();
        //Verificação
        assertEquals(0, clientes.size());
    }

    @Test
    void deveListarDoisClientes() {
        Cliente joao = new Cliente(1L, "João", "942.965.820-46");
        Cliente pedro = new Cliente(2L, "Pedro", "209.562.500-50");
        when(clienteRepository.findAll()).thenReturn(List.of(joao, pedro));

        List<ClienteListagem> clientes = clienteService.listar();
        assertThat(clientes)
                .extracting("id", "nome", "cpf")
                .containsExactly(
                        tuple(1L, "João", "942.965.820-46"),
                        tuple(2L, "Pedro", "209.562.500-50")
                );

        /*
        ClienteListagem joaoDto = new ClienteListagem(1L, "João", "asdasdas");
        ClienteListagem pedroDto = new ClienteListagem(2L, "Pedro", "209.562.500-50");

        assertThat(clientes)
                .usingFieldByFieldElementComparator()
                .containsExactly(joaoDto, pedroDto);
        */
    }
//deveBuscarClientePorCpf
//deveCriarCliente
//deveAtualizarNomeCliente
//deveApagarCliente
//
//naoDeveAtualizarSeMesmoNome
//deveFalharAoBuscarPorCpfInexistente
//deveFalharSeNaoEncontrarCliente


}