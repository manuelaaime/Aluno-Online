package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno){ /*Iniciando o CRUD: create*/
        alunoRepository.save(aluno);
    }
    public List<Aluno> listarTodosAlunos()
    {return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);
    }
    public void deletarAlunoPorId(Long id){
        alunoRepository.deleteById(id);
    }
}