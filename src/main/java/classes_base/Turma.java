package classes_base;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int id;
    private String numero;
    private String serie;
    private List<Integer> listaIdAlunos;
    private int capacidade;
    private int idProfessor;

    public Turma() {}

    public Turma(int id, String numero, String serie, List<Integer> listaIdAlunos, int capacidade, int idProfessor) {
        this.id = id;
        this.numero = numero;
        this.serie = serie;
        this.listaIdAlunos = listaIdAlunos;
        this.capacidade = capacidade;
        this.idProfessor = idProfessor;
    }

    public Turma(int id, String numero, String serie, int capacidade, int idProfessor) {
        this.id = id;
        this.numero = numero;
        this.serie = serie;
        this.capacidade = capacidade;
        this.idProfessor = idProfessor;
        this.listaIdAlunos = new ArrayList<>();
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

    public List<Integer> getListaIdAlunos() {
        return listaIdAlunos;
    }

    public void setListaIdAlunos(List<Integer> listaIdAlunos) {
        this.listaIdAlunos = listaIdAlunos;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", serie='" + serie + '\'' +
                ", listaIdAlunos=" + listaIdAlunos +
                ", capacidade=" + capacidade +
                ", idProfessor=" + idProfessor +
                '}';
    }
}
