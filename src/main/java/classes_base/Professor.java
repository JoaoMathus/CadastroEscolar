package classes_base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Professor extends Pessoa{
    private List<Turma> turmas;
    private String cpf;

    public Professor() {}

    public Professor(int id, String nome, String telefone, String celular, String dataNascimento,
                     String cpf) {
        super (id, nome, telefone, celular, dataNascimento);
        this.cpf = cpf;
        this.setNome(nome);
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

    // Será usada para testes
    public void listarTurmas() {
        System.out.println("O professor de CPF " + cpf + " têm as Turmas:");
        System.out.println(turmas);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "turmas=" + turmas +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public void testarProfessor() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();


        Professor professortur = new Professor();


//        while (true) {
//            System.out.print("Digite o número da turma para adicionar (ou '0' para finalizar): ");
//            int turma = scanner.nextInt();
//            if (turma == 0) {
//                break;
//            }
//            professortur.adicionarTurma(turma);
//        }
//        professortur.listarTurmas();

        System.out.println(professortur);

        scanner.close();
    }
}
