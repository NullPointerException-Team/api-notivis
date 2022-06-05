package com.npteam.apinotivis.controller;

import com.npteam.apinotivis.model.Professor;
import com.npteam.apinotivis.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/professores/listar")
    public ResponseEntity<List<Professor>> listarProfessores() {
        return ResponseEntity.ok().body(professorService.listarProfessores());
    }

    @GetMapping("/profesores/{id_professor}")
    public ResponseEntity<Professor> listarProfessor(@PathVariable @Valid Integer id_professor){
        return ResponseEntity.ok().body(professorService.listarProfessor(id_professor));
    }

    @PostMapping("/professores/cadastrar/materia/{codigo}")
    public ResponseEntity<Void> cadastrarProfessor(@RequestBody Professor professor, @PathVariable Integer codigo){
        professorService.cadastrarProfessor(professor, codigo);

        return ResponseEntity.status(201).build();
    }
}
