package br.com.tt.petshop.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String apelido;

    @Column
    private LocalDate nascimento;

    //FK - chave estrangeira - Foreign Key
    @JoinColumn(name = "cliente_id")
    @ManyToOne
    private Cliente tutor;

    Animal() {
    }

    public Animal(Long id, String apelido, LocalDate nascimento) {
        this.id = id;
        this.apelido = apelido;
        this.nascimento = nascimento;
    }

    public Long getId() {
        return id;
    }

    public String getApelido() {
        return apelido;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
}
