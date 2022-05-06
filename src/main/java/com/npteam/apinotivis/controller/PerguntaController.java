package com.npteam.apinotivis.controller;


import com.npteam.apinotivis.dao.PerguntaDAO;
import com.npteam.apinotivis.model.Aluno;
import com.npteam.apinotivis.model.Pergunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PerguntaController {

  @Autowired
  private PerguntaDAO perguntaDAO;

  @GetMapping("/perguntas/listar/todas")
  public ResponseEntity<List<Pergunta>> listarTodasPerguntas() {
    ResponseEntity<List<Pergunta>> response = ResponseEntity.ok(perguntaDAO.findAll());
    if (response != null) {
      return response;
    }
    return ResponseEntity.notFound().build();

    //return ResponseEntity.ok(perguntaDAO.findAll());
  }

    @PostMapping("/perguntas/criar")
    public ResponseEntity<?> criarNovaPergunta(@RequestBody Pergunta pergunta) {
      perguntaDAO.saveAndFlush(pergunta);

      return  ResponseEntity.status(201).build();
    }



}
