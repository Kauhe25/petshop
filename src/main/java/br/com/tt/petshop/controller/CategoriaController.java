package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.CategoriaConsulta;
import br.com.tt.petshop.dto.CategoriaCriacao;
import br.com.tt.petshop.dto.CategoriaListagem;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.model.Categoria;
import br.com.tt.petshop.service.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
@Api(tags = "Categorias", description = "Controller para gestão de Categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    //LISTA - GET - 200(ok) - /categorias
    @ApiOperation("Obtém a lista de categorias")
    @GetMapping
    public List<CategoriaListagem> lista () {
        return categoriaService.listar();
    }


    //UNITÁRIO - GET - 200 (ok) - /categorias/{ID}
    @GetMapping("/{id}")
    @ApiOperation("Obtém a categoria por Id")
    public CategoriaConsulta obterPorId(@PathVariable("id") Long id){
        return categoriaService.categoriaPorId(id);
    }

    //APAGAR - DELETE - 204 (no content) - /categorias/{cpf/ID}
    @DeleteMapping("/{id}")
    public void apagarCategoria(@PathVariable("id") Long id){
        categoriaService.apagar(id);
    }


    //ATUALIZAÇÃO parcial -  PATCH - 204(no content) - /categorias/{ID}
    @PatchMapping("/{id}")
    //TODO: arrumar Nome
    public void atualiza(@PathVariable Long id, @RequestBody String nome){
        categoriaService.atualiza(id, nome);
    }

    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid CategoriaCriacao categoriaCriacao){
        System.out.println("Entrou aqui");
        //categoriaService.criar(categoriaCriacao);
        URI location = URI.create(String.format("/categorias/%s", categoriaService.criar(categoriaCriacao)));
        return ResponseEntity.created(location).build();
    }


}
