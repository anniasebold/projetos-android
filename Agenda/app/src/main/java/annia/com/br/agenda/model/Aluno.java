package annia.com.br.agenda.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * Created by annia on 29/12/2019.
 */

public class Aluno {
    private final String nome;
    private final String telefone;
    private final String email;
    private final static ArrayList<Aluno> alunos = new ArrayList<>();

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
