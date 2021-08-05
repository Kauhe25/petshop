package br.com.tt.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoriaConsulta {
    private Long id;
    private String nome;
    private Integer quantidadeProdutos;
}
