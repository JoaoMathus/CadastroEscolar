package classes_base;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String matricula;
    private String serie;
    private int idTurma;
    private List<Disciplina> disciplinas;

    private String tipoSanguineo;
    private String cpfDoResponsavel;
    private boolean aprovado;

    public Aluno() {}

    public Aluno(int id, String nome, String telefone, String celular,
                 String dataNascimento, String matricula, String serie,
                 int idTurma, String tipoSanguineo,
                 String cpfDoResponsavel, boolean aprovado) {
        super(id, nome, telefone, celular, dataNascimento);
        this.matricula = matricula;
        this.serie = serie;
        this.idTurma = idTurma;
        this.tipoSanguineo = tipoSanguineo;
        this.cpfDoResponsavel = cpfDoResponsavel;
        this.aprovado = aprovado;
    }

    public Aluno(int id, String nome, String telefone, String celular, String dataNascimento,
                 String matricula, String serie, int idTurma, List<Disciplina> disciplinas,
                 String tipoSanguineo, String cpfDoResponsavel, boolean aprovado) {
        super(id, nome, telefone, celular, dataNascimento);
        this.matricula = matricula;
        this.serie = serie;
        this.idTurma = idTurma;
        this.disciplinas = disciplinas;
        this.tipoSanguineo = tipoSanguineo;
        this.cpfDoResponsavel = cpfDoResponsavel;
        this.aprovado = aprovado;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String tel) {
        telefone = tel;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String cel) {
        celular = cel;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String data) {
        dataNascimento = data;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getCpfDoResponsavel() {
        return cpfDoResponsavel;
    }

    public void setCpfDoResponsavel(String cpfDoResponsavel) {
        this.cpfDoResponsavel = cpfDoResponsavel;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disc) {
        this.disciplinas.add(disc);
    }

    public void removerDisciplina(Disciplina disc) {
        this.disciplinas.remove(disc);
    }

}
