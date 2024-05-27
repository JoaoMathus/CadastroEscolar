package classes_base;

public class Disciplina {
    private int id;
    private String nome;
    private float notaBimestre1;
    private float notaBimestre2;
    private float notaBimestre3;
    private float notaBimestre4;
    private String anoLetivo;
    private boolean aprovado;
    private int idAluno;

    public Disciplina(int id, String nome, float notaBimestre1, float notaBimestre2,
                      float notaBimestre3, float notaBimestre4, String anoLetivo,
                      boolean aprovado, int idAluno) {
        this.id = id;
        this.nome = nome;
        this.notaBimestre1 = notaBimestre1;
        this.notaBimestre2 = notaBimestre2;
        this.notaBimestre3 = notaBimestre3;
        this.notaBimestre4 = notaBimestre4;
        this.anoLetivo = anoLetivo;
        this.aprovado = aprovado;
        this.idAluno = idAluno;
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

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public float getNotaBimestre1() {
        return notaBimestre1;
    }

    public void setNotaBimestre1(float notaBimestre1) {
        this.notaBimestre1 = notaBimestre1;
    }

    public float getNotaBimestre2() {
        return notaBimestre2;
    }

    public void setNotaBimestre2(float notaBimestre2) {
        this.notaBimestre2 = notaBimestre2;
    }

    public float getNotaBimestre3() {
        return notaBimestre3;
    }

    public void setNotaBimestre3(float notaBimestre3) {
        this.notaBimestre3 = notaBimestre3;
    }

    public float getNotaBimestre4() {
        return notaBimestre4;
    }

    public void setNotaBimestre4(float notaBimestre4) {
        this.notaBimestre4 = notaBimestre4;
    }

    public float calcularMedia(float nota1, float nota2,
                               float nota3, float nota4) {
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", notaBimestre1=" + notaBimestre1 +
                ", notaBimestre2=" + notaBimestre2 +
                ", notaBimestre3=" + notaBimestre3 +
                ", notaBimestre4=" + notaBimestre4 +
                ", anoLetivo='" + anoLetivo + '\'' +
                ", aprovado=" + aprovado +
                ", idAluno=" + idAluno +
                '}';
    }
}
