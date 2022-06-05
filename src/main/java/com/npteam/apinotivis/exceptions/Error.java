package com.npteam.apinotivis.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

  private Integer status;
  private OffsetDateTime data;
  private String titulo;

  private List<Campo> campos;

  public Error(Integer status, OffsetDateTime data, String titulo) {
    this.status = status;
    this.data = data;
    this.titulo = titulo;
  }

  @Getter
  @AllArgsConstructor
  public static class Campo {
    private String nome;
    private String mensagem;
  }
}
