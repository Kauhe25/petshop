package br.com.tt.petshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
@EqualsAndHashCode(of = {"id", "nome", "cpf"})
@ToString
@Getter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerado pelo próprio banco
    @Column(name = "id_cliente")
    private Long id;

    @Column//Sem o name indica que o nome é igual ao banco
    private String nome;

    @Column
    private String cpf;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.REMOVE)
    private List<Animal> animais;

    //Construtor normal, com todos os campos
    public Cliente(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public void alterarNome(String nome) {
        this.nome = nome;
    }
}
