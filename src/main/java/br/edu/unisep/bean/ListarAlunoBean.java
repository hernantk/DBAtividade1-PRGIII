package br.edu.unisep.bean;

import br.edu.unisep.model.entity.Aluno;
import br.edu.unisep.usecase.ListarAlunoUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListarAlunoBean {
    ListarAlunoUseCase useCase= new ListarAlunoUseCase();

    @Getter @Setter
    private List<Aluno> listaAlunos;

    @PostConstruct
    public void iniciar(){
        this.listaAlunos=useCase.executar();
    }

}
