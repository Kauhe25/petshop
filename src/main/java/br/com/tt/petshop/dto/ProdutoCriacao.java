package br.com.tt.petshop.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoCriacao {

    @NotBlank(message = "Informe a descrição do produto")
    private String descricao;

    @NotBlank(message = "Informe o valor")
    private BigDecimal valor;
}
