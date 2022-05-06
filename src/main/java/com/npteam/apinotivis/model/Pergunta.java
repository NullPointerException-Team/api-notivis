package com.npteam.apinotivis.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "perguntas")
public class Pergunta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_pergunta;

  private Integer id_materia;
  private Integer id_aluno;
  private String pergunta_texto;
  private Boolean status_respondida;
}