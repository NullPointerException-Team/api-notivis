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
public class LoginController {

  @Autowired
  private AlunoServiceImpl alunoServices;

  @Autowired
  private AlunoDAO alunoDAO;

  @PostMapping("/alunos/login")
  public ResponseEntity<?> loginAluno(@RequestBody Aluno aluno) {
    Optional<Aluno> alunoRetorno = alunoDAO.findById(aluno.getNumero_matricula());
    if (!alunoRetorno.isEmpty()) {
      return ResponseEntity.ok(alunoRetorno);
    }
    return ResponseEntity.notFound().build();
  }

}