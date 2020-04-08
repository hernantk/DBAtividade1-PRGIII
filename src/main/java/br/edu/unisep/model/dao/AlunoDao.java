package br.edu.unisep.model.dao;

import br.edu.unisep.model.entity.Aluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
    private Connection connect() throws  ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aluno",
                "postgres","jdfnil54");
        return connection;
    }
    public List<Aluno> listarTodos(){
        var listaAlunos= new ArrayList<Aluno>();

        try{
            var connection= connect();
            var st=connection.createStatement();
            var result=st.executeQuery("select * from evaluation");
            while (result.next()){
                var aluno=new Aluno();
                aluno.setId_aluno(result.getInt("id_evaluation"));
                aluno.setAluno(result.getString("student_name"));
                aluno.setN_apresentacao(result.getDouble("grade_presentation"));
                aluno.setN_linguagem(result.getDouble("grade_language"));
                aluno.setN_proposta(result.getDouble("grade_proposal"));
                aluno.setN_resultados(result.getDouble("grade_results"));
                aluno.setN_notaFinal(result.getDouble("grade_evaluation"));
                listaAlunos.add(aluno);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return listaAlunos;
    }
    public void salvar(Aluno aluno){
        try {
            var connection=connect();
            var ps = connection.prepareStatement("INSERT INTO evaluation(student_name, grade_presentation, grade_language, grade_proposal, grade_results, grade_evaluation) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1,aluno.getAluno());
            ps.setDouble(2,aluno.getN_apresentacao());
            ps.setDouble(3,aluno.getN_linguagem());
            ps.setDouble(4,aluno.getN_proposta());
            ps.setDouble(5,aluno.getN_resultados());
            ps.setDouble(6,aluno.notaFinal());
            ps.execute();
            ps.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
