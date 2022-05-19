package com.npteam.apinotivis.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "professor")
@Data
public class Professor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 150)
  private String nome;

}
