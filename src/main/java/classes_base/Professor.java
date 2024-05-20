package classes_base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Professor extends Pessoa{
    private List<Turma> turmas;
    private String cpf;

    public Professor(String nome, int matricula, int telefone, int celular, String cpf) {
        super (nome, matricula, telefone, celular, cpf);
        this.cpf = cpf;
        this.setNome(nome);
        this.matricula
        this.turmas = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }


    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        turmas.remove(turma);
    }

    public void listarTurmas() {
        System.out.println("O professor de CPF " + cpf + " têm as Turmas:");
        System.out.println(turmas);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "cpf='" + cpf + '\'' + ", turmas=" + turmas + '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();


        Professor professortur = new Professor(cpf);


        while (true) {
            System.out.print("Digite o número da turma para adicionar (ou '0' para finalizar): ");
            int turma = scanner.nextInt();
            if (turma == 0) {
                break;
            }
            professortur.adicionarTurma(turma);
        }
        professortur.listarTurmas();

        System.out.println(professortur);

        scanner.close();
    }
}
