package com.npteam.apinotivis.dao;

import com.npteam.apinotivis.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaDAO extends JpaRepository<Pergunta, Integer> {
}
