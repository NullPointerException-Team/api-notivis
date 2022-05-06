package com.npteam.apinotivis.services;

import com.npteam.apinotivis.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAlunoServices {

  public List<Aluno> listarAlunos();
}
