package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.CategoriaConsulta;
import br.com.tt.petshop.dto.CategoriaCriacao;
import br.com.tt.petshop.dto.CategoriaListagem;
import br.com.tt.petshop.mapper.CategoriaMapper;
import br.com.tt.petshop.model.Categoria;
import br.com.tt.petshop.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

//    public CategoriaService(CategoriaRepository categoriaRepository) {
//        this.categoriaRepository = categoriaRepository;
//    }

    public List<CategoriaListagem> listar(){
        return categoriaRepository
                .findAll()
                .stream()
                //.map(categoria -> new CategoriaListagem(categoria.getId(), categoria.getNome())) //Inline
                //.map(categoria -> converterParaCategoriaListagem(categoria))
//                .map(this::converterParaCategoriaListagem)
//                .map(categoria -> CategoriaMapper.INSTANCE.converterListagem(categoria))
                .map(CategoriaMapper.INSTANCE::converterListagem)
                .collect(Collectors.toList());
    }

//    private CategoriaListagem converte(Categoria categoria) {
//        return CategoriaMapper.INSTANCE.converterListagem(categoria);
//    }

//    private CategoriaListagem converterParaCategoriaListagem(Categoria categoria) {
//        return new CategoriaListagem(categoria.getId(), categoria.getNome());
//    }

    //Buscar categoria pelo ID
    public CategoriaConsulta categoriaPorId(Long id){
        return categoriaRepository
                .findById(id).map(CategoriaMapper.INSTANCE::converterConsulta)
                .orElseThrow();
    }

    //Apagar por ID
    public void apagar (Long id){
        categoriaRepository.deleteById(id);
    }


    //Update
    public void atualiza(Long id, String nome){

        Categoria categoria = categoriaRepository.findById(id).orElseThrow();

        if(!categoria.getNome().equalsIgnoreCase(nome)){
            categoria.alterarNome(nome);
            categoriaRepository.save(categoria);
        }
    }

    // insert
    public Long criar(CategoriaCriacao categoriaCriacao){
        Categoria categoria = CategoriaMapper.INSTANCE.fromCriacao(categoriaCriacao);
        Categoria categoriaSalva =  categoriaRepository.save(categoria);
        return categoriaSalva.getId();
    }

}
