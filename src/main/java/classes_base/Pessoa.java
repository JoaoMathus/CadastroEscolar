package classes_base;

public class Pessoa {
    private int matricula;//id nome telefone celular e data de nascimento
    private String nome;
    private int telefone;
    private int celular;
    private String cpf;

    public int getMatricula(){
        return matricula;
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

    public void setTelefone(int telefone){
        this.telefone = telefone;
    }

    public int getCelular(){
        return celular;
    }

    public void setCelular(int celular){
        this.celular = celular;
    }

    public String getCpf(){
        return cpf;
    }






}
