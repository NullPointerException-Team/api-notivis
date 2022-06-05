package com.npteam.apinotivis.services;

import com.npteam.apinotivis.dao.AlunoDAO;
import com.npteam.apinotivis.exceptions.EntidadeNaoEncontradaException;
import com.npteam.apinotivis.model.Aluno;
import com.npteam.apinotivis.model.Materia;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoServices {

  @Autowired
  private AlunoDAO alunoDAO;

  @Autowired
  private MateriaService materiaService;

  @Override
  public List<Aluno> listarAlunos() {
    return alunoDAO.findAll();
  }

  public Aluno listarAluno(Integer matricula) {
    Optional<Aluno> aluno = alunoDAO.findById(matricula);

    return aluno.orElseThrow(()-> new EntidadeNaoEncontradaException("Aluno não encontrado"));
  }

  public Aluno cadastrarAluno(Aluno aluno, Integer codigo) {
    Materia materia = materiaService.listarMateria(codigo);
    aluno.addMateria(materia);

    return alunoDAO.save(aluno);
  }

  public Aluno buscarAlunoPorId(Integer id) {
    return alunoDAO.findById(id)
            .orElseThrow(() -> new EntidadeNaoEncontradaException("Aluno não encontrado"));
  }
}
