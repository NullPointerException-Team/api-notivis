package com.npteam.apinotivis.dao;

import com.npteam.apinotivis.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaDAO extends JpaRepository<Pergunta, Integer> {
}
