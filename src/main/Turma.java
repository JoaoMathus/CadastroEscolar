package main;

import java.util.HashSet;

public class Turma {
    private Professor professor;   // professor designado.
    private HashSet<Aluno> alunos; // conjunto de alunos.
    private final String numero;   // número da turma.

    public Turma() {
        this.alunos = new HashSet<>();
        numero = "0";     // será configurado automaticamente.
    }

    public Turma(Professor professor) {
        this.professor = professor;
        this.alunos = new HashSet<>();
        numero = "0";     // será configurado automaticamente.
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public float calcularMediaDaTurma() {
        // Abrace o paradigma funcional
        return (float) alunos.stream()
                .mapToDouble(Aluno::calcularMedia)
                .sum() / alunos.size();
    }

    public void publicarNota(Aluno aluno, String prova, float nota) {
        // Publicar uma nota de um aluno específico.
        alunos.stream()
                .filter(a -> a.equals(aluno))
                .forEach(a -> a.setNota(prova, nota));
    }

    public void alocarProfessor(Professor professor) {
        this.professor = professor;
    }
}
