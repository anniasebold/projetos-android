package annia.com.br.agenda.DAO;

import java.util.ArrayList;
import java.util.List;

import annia.com.br.agenda.model.Aluno;

/**
 * Created by annia on 29/12/2019.
 */

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salvarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
    //Está sendo mandado uma cópia da Lista de Alunos, para não acabar com o Encapsulamento
}
