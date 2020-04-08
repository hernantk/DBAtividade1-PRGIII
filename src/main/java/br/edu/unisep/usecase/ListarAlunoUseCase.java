package br.edu.unisep.usecase;

import br.edu.unisep.model.dao.AlunoDao;
import br.edu.unisep.model.entity.Aluno;

import java.util.List;

public class ListarAlunoUseCase {

    public List<Aluno> executar(){
        var dao= new AlunoDao();
        return dao.listarTodos();
    }
}
