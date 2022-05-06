package com.npteam.apinotivis.services;

import com.npteam.apinotivis.dao.AlunoDAO;
import com.npteam.apinotivis.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoServices {

  @Autowired
  private AlunoDAO alunoDAO;

  @Override
  public List<Aluno> listarAlunos() {
    return alunoDAO.listarAlunos();
  }
}
