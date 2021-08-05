package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.ProdutoCriacao;
import br.com.tt.petshop.service.ProdutoService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
@Api(tags = "produtos", description = "Controller para gestao de produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity cria(ProdutoCriacao produtoCriacao){
        URI location =
                URI.create(String.format("/produtos/%s",produtoService.criar(produtoCriacao)));
        return ResponseEntity.created(location).build();
    }
}
