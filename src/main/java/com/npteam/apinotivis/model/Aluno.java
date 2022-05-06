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
    private Integer numero_matricula;
    private String nome;

//    @JoinColumn(name = "perguntas")
//    @ElementCollection
//    @OneToMany
//    private List<Pergunta> listaAnotacoes;


}
