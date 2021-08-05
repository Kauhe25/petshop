package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.CategoriaConsulta;
import br.com.tt.petshop.dto.CategoriaCriacao;
import br.com.tt.petshop.dto.CategoriaListagem;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.model.Categoria;
import br.com.tt.petshop.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaListagem converterListagem(Categoria categoria);

    @Mapping(target = "quantidadeProdutos",
            expression = "java(categoria.getProdutos().size())")
    CategoriaConsulta converterConsulta(Categoria categoria);

    //Método no padrão: NoQueQueroConverter from(oQueQueroConverter);


    @Mapping(ignore = true, target="id")
    @Mapping(ignore = true, target="produtos")
    Categoria fromCriacao(CategoriaCriacao categoriaCriacao);




}
