package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.ProdutoConsulta;
import br.com.tt.petshop.dto.ProdutoCriacao;
import br.com.tt.petshop.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(source = "categoria.nome", target = "categoria")
    ProdutoConsulta converterParaProdutoConsulta(Produto produto);

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "categoria")
    Produto fromCriacao(ProdutoCriacao produto);
}
