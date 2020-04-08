package br.edu.unisep.bean;

import br.edu.unisep.model.entity.Aluno;
import br.edu.unisep.usecase.InserirAlunoUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class InserirAlunoBean {
    private InserirAlunoUseCase useCase=new InserirAlunoUseCase();
    @Getter @Setter
    private Aluno aluno = new Aluno();



    public String inserir(){
        aluno.getN_notaFinal();
        useCase.executar(this.aluno);
        return "index?faces-redirect=true";

    }
}
