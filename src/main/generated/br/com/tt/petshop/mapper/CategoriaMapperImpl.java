package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.CategoriaConsulta;
import br.com.tt.petshop.dto.CategoriaListagem;
import br.com.tt.petshop.model.Categoria;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-20T20:09:25-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaListagem converterListagem(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Long id = null;
        String nome = null;

        id = categoria.getId();
        nome = categoria.getNome();

        CategoriaListagem categoriaListagem = new CategoriaListagem( id, nome );

        return categoriaListagem;
    }

    @Override
    public CategoriaConsulta converterConsulta(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Long id = null;
        String nome = null;

        id = categoria.getId();
        nome = categoria.getNome();

        Integer quantidadeProdutos = categoria.getProdutos().size();

        CategoriaConsulta categoriaConsulta = new CategoriaConsulta( id, nome, quantidadeProdutos );

        return categoriaConsulta;
    }
}
