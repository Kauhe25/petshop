package br.com.tt.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClienteListagem {
    private Long id;
    private String nome;
    private String cpf;
}
