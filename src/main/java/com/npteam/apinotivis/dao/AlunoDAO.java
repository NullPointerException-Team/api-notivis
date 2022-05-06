package com.npteam.apinotivis.dao;

import com.npteam.apinotivis.dto.AlunoDTO;
import com.npteam.apinotivis.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

  @Query("SELECT " +
          "new com.npteam.apinotivis.dto.AlunoDTO(" +
          "aluno.numero_matricula," +
          "aluno.nome) " +
          "FROM Aluno as aluno")
  public List<Aluno> listarAlunos();

  @Query("select new com.npteam.apinotivis.dto.AlunoDTO(" +
          "aluno.numero_matricula," +
          "aluno.nome," +
          "aluno.senha) FROM Aluno as aluno WHERE aluno.numero_matricula = :id")
  public Aluno buscarAlunoPorMatricula(@Param("id") Integer matricula);




}