package br.edu.unisep.usecase;

import br.edu.unisep.model.dao.AlunoDao;
import br.edu.unisep.model.entity.Aluno;

public class InserirAlunoUseCase {

    public void executar(Aluno aluno){
        AlunoDao dao = new AlunoDao();

        dao.salvar(aluno);

    }
}
