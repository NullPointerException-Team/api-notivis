package com.npteam.apinotivis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_matricula")
    private Integer numero_matricula;
    private String nome;
    private String senha;

//    @JoinColumn(name = "perguntas")
//    @ElementCollection
//    @OneToMany
//    private List<Pergunta> listaAnotacoes;


}
