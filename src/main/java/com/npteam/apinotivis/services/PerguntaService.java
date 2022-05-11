package com.npteam.apinotivis.services;

import com.npteam.apinotivis.dao.PerguntaDAO;
import com.npteam.apinotivis.model.Pergunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerguntaService {

    @Autowired
    private PerguntaDAO perguntaDAO;

    @Autowired
    private AulaService aulaService;

    public void cadastrarPergunta(Integer id_aula, Pergunta pergunta) {
        pergunta.setAula(aulaService.listarAula(id_aula));
        perguntaDAO.save(pergunta);
    }
}
