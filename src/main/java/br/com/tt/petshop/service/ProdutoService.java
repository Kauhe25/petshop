package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ProdutoConsulta;
import br.com.tt.petshop.dto.ProdutoCriacao;
import br.com.tt.petshop.mapper.ProdutoMapper;
import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoConsulta produtoPorId(Long id){
        return produtoRepository.findById(id)
                .map(ProdutoMapper.INSTANCE::converterParaProdutoConsulta)
                .orElseThrow();
    }

    public List<ProdutoConsulta> produtosPorIdCategoria(Long id){
        return produtoRepository.findByCategoriaId(id)
                .stream()
                .map(ProdutoMapper.INSTANCE::converterParaProdutoConsulta)
                .collect(Collectors.toList());
    }

    public List<ProdutoConsulta> produtosPorIntervaloDeValor(BigDecimal minimo, BigDecimal maximo){
        return produtoRepository.findByValorBetween(minimo, maximo)
                .stream()
                .map(ProdutoMapper.INSTANCE::converterParaProdutoConsulta)
                .collect(Collectors.toList());
    }

    public List<ProdutoConsulta> listar(){
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoMapper.INSTANCE::converterParaProdutoConsulta)
                .collect(Collectors.toList());
    }

    public Long criar(ProdutoCriacao produtoCriacao){
        Produto produto = ProdutoMapper.INSTANCE.fromCriacao(produtoCriacao);
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoSalvo.getId();

    }


}
