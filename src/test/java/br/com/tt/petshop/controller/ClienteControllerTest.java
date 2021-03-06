package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.service.ClienteService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(controllers = ClienteController.class) //Teste integrado - não é unitário!!
class ClienteControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean //Equivalente ao @Mock, mas só funciona nos testes integrados
    ClienteService clienteService;

    @Test
    void deveRetornarLista() throws Exception{
        Mockito.when(clienteService.listar()).thenReturn(List.of(
                new ClienteListagem(1L, "Fulano", "286.522.290-07")
        ));

        mvc.perform(MockMvcRequestBuilders.get("/clientes"))//Perform = chamar
                .andExpect(MockMvcResultMatchers.status().isOk()) //OK == SUCESSO
                .andExpect(MockMvcResultMatchers.jsonPath("[0].id", CoreMatchers.equalTo(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].cpf", CoreMatchers.equalTo("286.522.290-07")))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].nome", CoreMatchers.equalTo("Fulano")));
    }

}