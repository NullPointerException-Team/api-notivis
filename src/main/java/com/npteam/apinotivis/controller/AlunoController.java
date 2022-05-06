package com.npteam.apinotivis.controller;

import com.npteam.apinotivis.dao.AlunoDAO;
import com.npteam.apinotivis.model.Aluno;
import com.npteam.apinotivis.services.AlunoServiceImpl;
import com.npteam.apinotivis.services.IAlunoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.List;

@RestController
// @CrossOrigin("*")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl alunoServices;

  @Autowired
  private AlunoDAO alunoDAO;

  @GetMapping("/teste")
  public String helloWorld() {
    return "Hello World!";
  }

  @GetMapping("/alunos/listar")
  public ResponseEntity<List<Aluno>> listarTodos() {
    ResponseEntity<List<Aluno>> response = ResponseEntity.ok(alunoServices.listarAlunos());
    if (response != null) {
      return response;
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/alunos/buscar/{id}")
  public ResponseEntity<?> buscarAlunoPorId(@PathVariable Integer id) {
    Optional<Aluno> aluno = alunoDAO.findById(id);
    if (!aluno.isEmpty()) {
      return ResponseEntity.ok(aluno);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping("/alunos/cadastrar")
  public ResponseEntity<?> cadastrarAluno(@RequestBody Aluno aluno) {
    alunoDAO.saveAndFlush(aluno);

    return ResponseEntity.status(201).build();
  }

}