package com.npteam.apinotivis.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perguntas")
public class Pergunta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String conteudo;
  private Integer numero_matricula_aluno;
  private Boolean status_respondida = Boolean.FALSE;

}