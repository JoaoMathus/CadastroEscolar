package classes_base;

public class Disciplina {
    private int id;
    private String nome;
    private float av1;
    private float av2;
    private float media;
    private int idaluno;

    public Disciplina(int id, String nome, float av1, float av2, int idaluno) {
        this.id = id;
        this.nome = nome;
        this.av1 = av1;
        this.av2 = av2;
        this.media = (av1 + av2) / 2;
        this.idaluno = idaluno;
    }

    public Disciplina() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAv1() {
        return av1;
    }

    public void setAv1(float av1) {
        this.av1 = av1;
    }

    public float getAv2() {
        return av2;
    }

    public void setAv2(float av2) {
        this.av2 = av2;
    }

    public void calcularMedia() {
        this.media = getAv1() + getAv2() / 2;
    }

    public float getMedia() {
        return media;
    }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }
}
