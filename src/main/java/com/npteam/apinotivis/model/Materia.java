package com.npteam.apinotivis.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "materia")
@Data
public class Materia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codigo;
  private String descricao;

  @JoinColumn(name = "id_professor")
  private Integer id_professor;
}
