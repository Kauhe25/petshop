package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.CategoriaListagem;
import br.com.tt.petshop.service.CategoriaService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(controllers = CategoriaController.class)
class CategoriaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CategoriaService categoriaService;

    @Test
    void deveRetornarListaDeCategorias() throws Exception{
        Mockito.when(categoriaService.listar()).thenReturn(List.of(
                new CategoriaListagem(1L,"Medicamentos")
        ));

        mockMvc.perform(MockMvcRequestBuilders.get("/categorias"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //OK == SUCESSO
                .andExpect(MockMvcResultMatchers.jsonPath("[0].id", CoreMatchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].nome", CoreMatchers.is("Medicamentos")));

    }

}