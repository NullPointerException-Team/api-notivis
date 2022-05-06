package com.npteam.apinotivis.dao;

import com.npteam.apinotivis.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

  @Query("SELECT " +
          "new com.npteam.apinotivis.model.Aluno(" +
          "aluno.numero_matricula," +
          "aluno.nome) " +
          "FROM Aluno as aluno")
  public List<Aluno> listarAlunos();


}