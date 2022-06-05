package com.npteam.apinotivis.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
public class Error {

  private Integer status;
  private OffsetDateTime data;
  private String titulo;

  private List<Campo> campos;

  @Getter
  @AllArgsConstructor
  public class Campo {
    private String nome;
    private String mensagem;
  }
}
