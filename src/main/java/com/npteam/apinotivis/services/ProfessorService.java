package com.npteam.apinotivis.services;

import com.npteam.apinotivis.dao.ProfessorDAO;
import com.npteam.apinotivis.exceptions.EntidadeNaoEncontradaException;
import com.npteam.apinotivis.exceptions.ReturnExceptionHandler;
import com.npteam.apinotivis.model.Materia;
import com.npteam.apinotivis.model.Professor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorDAO professorDAO;

    @Autowired
    private MateriaService materiaService;

    public List<Professor> listarProfessores() {
        return professorDAO.findAll();
    }

    public Professor listarProfessor(Integer id_professor){
        Optional<Professor> professor = professorDAO.findById(id_professor);

        return professor.orElseThrow(()-> new EntidadeNaoEncontradaException("Professor não encontrado"));
    }

    public Professor cadastrarProfessor(Professor professor, Integer codigo) {
        Materia materia = materiaService.listarMateria(codigo);

        materia.setProfessor(professor);
        professor.addMateria(materia);

        return professorDAO.save(professor);
    }

}
