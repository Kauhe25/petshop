package br.com.tt.petshop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Categoria {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;

//    public Categoria(Long id, String nome) {
//        this.id = id;
//        this.nome = nome;
//    }

    public void alterarNome(String nome) {
        this.nome = nome;
    }
}
