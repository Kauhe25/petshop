package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ProdutoConsulta;
import br.com.tt.petshop.model.Categoria;
import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.repository.ProdutoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    ProdutoRepository produtoRepository;

    @InjectMocks
    ProdutoService produtoService;

    @Test
    void deveBuscarProdutosPorIdCategoria(){


        Categoria categoria =
                new Categoria(1L,"Higiene",null);

        Produto produtoSabonete =
                new Produto(10L,
                        "sabonete", BigDecimal.valueOf(12), categoria);
        Produto produtoShampoo =
                new Produto(11L,
                        "shampoo", BigDecimal.valueOf(16), categoria);
        Produto produtoAntiPulgas =
                new Produto(12L,
                        "anti pulgas", BigDecimal.valueOf(20), categoria);

        //Preparação
        Mockito.when(produtoRepository.
                findByCategoriaId(1L)).thenReturn(List.of(produtoSabonete,produtoShampoo,produtoAntiPulgas));

        //Ação
        List<ProdutoConsulta> produtos = produtoService.produtosPorIdCategoria(1L);

        // Verificação
        assertThat(produtos)
                //.usingFieldByFieldElementComparator()
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(
                new ProdutoConsulta(10L,"sabonete",BigDecimal.valueOf(12),"Higiene"),
                new ProdutoConsulta(11L,"shampoo",BigDecimal.valueOf(16),"Higiene"),
                new ProdutoConsulta(12L,"anti pulgas",BigDecimal.valueOf(20),"Higiene")
        );

    }


    @Test
    void deveBuscarProdutosPorIntervaloDeValor(){

        //Preparação
        Categoria categoria = new Categoria(1L,"Higiene",null);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(10L,  "sabonete", BigDecimal.valueOf(12), categoria));
        produtos.add(new Produto(11L,"shampoo", BigDecimal.valueOf(13), categoria));
        produtos.add(new Produto(12L,"anti pulgas", BigDecimal.valueOf(14), categoria));
        produtos.add(new Produto(13L,"anti carrapatos", BigDecimal.valueOf(15), categoria));


        Mockito.when(produtoRepository.
                findByValorBetween(BigDecimal.valueOf(12),BigDecimal.valueOf(15)))
                .thenReturn(produtos);

        //Ação
        List<ProdutoConsulta> produtosConsulta =produtoService
                .produtosPorIntervaloDeValor(BigDecimal.valueOf(12),BigDecimal.valueOf(15));

        // Verificação
        org.junit.jupiter.api.Assertions.assertEquals(4, produtosConsulta.size());


        //assertThat(produtosConsulta).size()
    }

    @Test
    void deveListarTodosOsProdutos(){

        Categoria categoria = new Categoria(1L,"Higiene",null);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(10L,  "sabonete", BigDecimal.valueOf(12), categoria));
        produtos.add(new Produto(11L,"shampoo", BigDecimal.valueOf(13), categoria));
        produtos.add(new Produto(12L,"anti pulgas", BigDecimal.valueOf(14), categoria));
        produtos.add(new Produto(13L,"anti carrapatos", BigDecimal.valueOf(15), categoria));

        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);

        List<ProdutoConsulta> produtosConsulta = produtoService.listar();

        assertThat(produtosConsulta)
                .usingFieldByFieldElementComparator()
                .containsExactly(
                        new ProdutoConsulta(10L,  "sabonete", BigDecimal.valueOf(12), "Higiene"),
                        new ProdutoConsulta(11L,"shampoo", BigDecimal.valueOf(13), "Higiene"),
                        new ProdutoConsulta(12L,"anti pulgas", BigDecimal.valueOf(14), "Higiene"),
                        new ProdutoConsulta(13L,"anti carrapatos", BigDecimal.valueOf(15), "Higiene")
                    );


    }

}