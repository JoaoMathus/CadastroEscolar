package classes_base;

import java.util.List;

public class Turma {
    private int id;
    private String numero;
    private String serie;
    private List<Aluno> listaAlunos;
    private Professor professor;
    private int capacidade;

    public Turma() {}

    public Turma(int id, String numero, String serie, List<Aluno> listaAlunos, Professor professor, int capacidade) {
        this.id = id;
        this.numero = numero;
        this.serie = serie;
        this.listaAlunos = listaAlunos;
        this.professor = professor;
        this.capacidade = capacidade;
    }

    public Turma(int id, String numero, String serie, int capacidade) {
        this.id = id;
        this.numero = numero;
        this.serie = serie;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void adicionarAluno(Aluno a) {
        this.listaAlunos.add(a);
    }

    public void removerAluno(Aluno a) {
        this.listaAlunos.remove(a);
    }
}
