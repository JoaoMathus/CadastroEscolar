package classes_base;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private String celular;
    private String dataNascimento;

    protected Pessoa() {}

    protected Pessoa(int id, String nome, String telefone, String celular, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public int getCelular(){
        return celular;
    }

    public void setCelular(String celular){
        this.celular = celular;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
