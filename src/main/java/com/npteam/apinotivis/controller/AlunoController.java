package com.npteam.apinotivis.controller;

import com.npteam.apinotivis.dao.AlunoDAO;
import com.npteam.apinotivis.model.Aluno;
import com.npteam.apinotivis.services.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoServices;

    @Autowired
    private AlunoDAO alunoDAO;

    @GetMapping("/alunos/listar")
    public List<Aluno> listarTodos() {
        return alunoServices.listarAlunos();
    }

    @GetMapping("/alunos/buscar/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Integer id) {
      return ResponseEntity.ok().body(alunoServices.buscarAlunoPorId(id));
    }

    @PostMapping("/alunos/cadastrar/materia/{codigo}")
    public ResponseEntity<Void> cadastrarAluno(@RequestBody Aluno aluno, @PathVariable(name = "codigo") Integer codigo) {
        alunoServices.cadastrarAluno(aluno, codigo);

        return ResponseEntity.status(201).build();
    }

}