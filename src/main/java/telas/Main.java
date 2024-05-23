package telas;

import acesso_banco.AlunoDAO;
import acesso_banco.DisciplinaDAO;
import acesso_banco.ProfessorDAO;
import acesso_banco.TurmaDAO;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hora de testar a conexão com o banco.");
        System.out.println();

        var professorDAO = new ProfessorDAO();
        professorDAO.inserir("Alomomola", "123.456.789-10", "99999-9999",
                "23.05.1999");
        var professorLista = professorDAO.selecionarTodos();

        var turmaDAO = new TurmaDAO();
        turmaDAO.inserir(30, "1o.", "1001", professorLista.getFirst().getId());
        var turmaLista = turmaDAO.selecionarTodos();

        var alunoDAO = new AlunoDAO();
        alunoDAO.inserir("Garbodor", "04.02.2003", "20039999",
                "91111-1111", "987.654.321-00",
                "O+", "1o.", turmaLista.getFirst().getId());
        var alunoLista = alunoDAO.selecionarTodos();

        var disciplinaDAO = new DisciplinaDAO();
        disciplinaDAO.inserir("Metemática", 6.6f, 7.3f, 6.6f,
                7.0f,
                "2024", false, alunoLista.getFirst().getId());
        var disciplinaLista = disciplinaDAO.selecionarTodos();
        disciplinaLista.forEach(System.out::println);
    }
}
