package classes_base;

import java.util.*;

public class Aluno extends Pessoa {

    final String matricula;
    Map<String, Float> notasDeProva = new HashMap<>();

    private String serie;
    private String numeroTurma;
    private String tipoSanguineo;
    private List<String> telefones = new ArrayList<String>();
    private String cpfDoResponsavel;

    public Aluno(Long id, String nome, String dataNascimento, String matricula, String serie, String numeroTurma, String tipoSanguineo, List<String> telefones, String cpfDoResponsavel) {
        super(id, nome, dataNascimento);
        this.matricula = matricula;
        this.serie = serie;
        this.numeroTurma = numeroTurma;
        this.tipoSanguineo = tipoSanguineo;
        this.telefones = telefones;
        this.cpfDoResponsavel = cpfDoResponsavel;
        notasDeProva.put("AV1", 0.0f);
        notasDeProva.put("AV2", 0.0f);
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public String getMatricula() { return matricula; }

    public Map<String, Float> getNotas() {
        return notasDeProva;
    }

    public String getSerie() { return serie; }

    public String getDataNascimento() { return dataNascimento; }

    public String getNumeroTurma() { return numeroTurma; }

    public String getTipoSanguineo() { return tipoSanguineo; }

    public List<String> getTelefones() { return telefones; }

    public String getCpfDoResponsavel() { return cpfDoResponsavel; }

    public void setNome(String nome) { this.nome = nome; }

    public void setNota(String prova, float nota) {
        notasDeProva.put(prova, nota);
    }

    public void setSerie(String serie) { this.serie = serie; }

    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public void setNumeroTurma(String numeroTurma) { this.numeroTurma = numeroTurma; }

    public void setTipoSanguineo(String tipoSanguineo) { this.tipoSanguineo = tipoSanguineo; }

    public void adicionarTelefone(String telefone) { telefones.add(telefone); }

    public void excluirTelefone(String telefone) { telefones.remove(telefone); }

    public void setCpfDoResponsavel(String cpfDoResponsavel) { this.cpfDoResponsavel = cpfDoResponsavel; }

    public float calcularMedia() {
        // A maravilha que é programação funcional
        return getNotas()
                .values()
                .stream()
                .reduce(0.0F, Float::sum) / getNotas().size();
    }
}
