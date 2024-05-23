package classes_base;

public class Professor extends Pessoa{
    private String cpf;

    public Professor() {}

    public Professor(int id, String nome, String cpf, String telefone, String dataNascimento) {
        super (id, nome, telefone, dataNascimento);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Professor{" +
                "id= " + getId() + '\'' +
                ", nome=" + getNome() + '\'' +
                ", telefone=" + getTelefone() + '\'' +
                ", dataNascimento=" + getDataNascimento() + '\'' +
                "cpf='" + cpf + '\'' +
                '}';
    }
}
