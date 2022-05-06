package com.npteam.apinotivis.dto;


import lombok.Data;

@Data
public class AlunoDTO {

  private Integer numero_matricula;
  private String nome;
  private String senha;

  public AlunoDTO(Integer numero_matricula, String nome) {
    this.numero_matricula = numero_matricula;
    this.nome = nome;
  }

  public AlunoDTO(Integer numero_matricula, String nome, String senha) {
    this.numero_matricula = numero_matricula;
    this.nome = nome;
    this.senha = senha;
  }


}
