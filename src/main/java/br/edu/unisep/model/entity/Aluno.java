package br.edu.unisep.model.entity;

import lombok.Data;
@Data
public class Aluno {
    private Integer id_aluno;
    private String aluno;
    private Double n_apresentacao;
    private Double n_linguagem;
    private Double n_proposta;
    private Double n_resultados;
    private Double n_notaFinal;

    public Double notaFinal(){
        return  this.n_notaFinal=(this.n_resultados+this.n_apresentacao+this.n_linguagem+this.n_proposta);
    }
}
