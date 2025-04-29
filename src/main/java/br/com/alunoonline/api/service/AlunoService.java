package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
    public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) { /*Iniciando o CRUD: create*/
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAlunoPorId(Long id) {
        alunoRepository.deleteById(id);
    }

    public void atualizarAlunoPorId(Long id, Aluno aluno) {
        Optional<Aluno> alunoDoBancoDeDados = buscarAlunoPorId(id);

        if (alunoDoBancoDeDados.isEmpty()) {
            /*empty: vazio. traduzindo: se o alunodeBD for igual a vazio*/
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "ALuno não encontrado no Banco de Dados");
            /*Throw: lance. Traduzindo: Lance um novo status - not found: não encontrado*/
        }

        Aluno alunoParaEditar = alunoDoBancoDeDados.get(); /* o get pega o aluno Optional que não pode ser tratado*/

        alunoParaEditar.setNome(aluno.getNome());
        alunoParaEditar.setCpf(aluno.getCpf());
        alunoParaEditar.setEmail(aluno.getEmail());

        /*esse processo devolve editado ao BD*/

        alunoRepository.save(alunoParaEditar); /*salvou o aluno atualizado*/
    }
}