package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
public class ProdutoConsulta {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private String categoria;
}
