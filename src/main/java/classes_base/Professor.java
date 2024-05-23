package classes_base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
                "cpf='" + cpf + '\'' +
                '}';
    }
}
