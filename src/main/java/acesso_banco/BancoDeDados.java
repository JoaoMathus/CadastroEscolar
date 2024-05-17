package acesso_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {
    private final String script = "CREATE TABLE IF NOT EXISTS aluno (\n" +
            "    idaluno INTEGER PRIMARY KEY,\n" +
            "    nome TEXT,\n" +
            "    datanascimento TEXT,\n" +
            "    matricula TEXT,\n" +
            "    telefone TEXT,\n" +
            "    cpfdoresponsavel TEXT,\n" +
            "    tiposanguineo TEXT,\n" +
            "    serie TEXT,\n" +
            "    aprovado INTEGER,\n" +
            "    fk_idturma INTEGER,\n" +
            "    FOREIGN KEY (fk_idturma) REFERENCES turma(idturma)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS professor (\n" +
            "    idprofessor INTEGER PRIMARY KEY,\n" +
            "    nome TEXT,\n" +
            "    cpf TEXT,\n" +
            "    telefone TEXT,\n" +
            "    datanascimento TEXT\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS turma (\n" +
            "    idturma INTEGER PRIMARY KEY,\n" +
            "    capacidade INTEGER,\n" +
            "    serie TEXT,\n" +
            "    numero TEXT,\n" +
            "    fk_idprofessor INTEGER,\n" +
            "    FOREIGN KEY (fk_idprofessor) REFERENCES professor(idprofessor)\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE IF NOT EXISTS disciplina (\n" +
            "    iddisciplina INTEGER PRIMARY KEY,\n" +
            "    av1 REAL,\n" +
            "    av2 REAL,\n" +
            "    media REAL,\n" +
            "    nome TEXT,\n" +
            "    fk_idaluno INTEGER,\n" +
            "    FOREIGN KEY (fk_idaluno) REFERENCES aluno(idaluno)\n" +
            ");";

    public BancoDeDados() {
        iniciarBanco();
    }

    private void iniciarBanco() {
        String arquivo_db = "dados.sqlite";
        try (Connection conexao = DriverManager.getConnection("jdbc:sqlite" + arquivo_db);
             Statement stmt = conexao.createStatement()) {
            stmt.execute(script);
        } catch (SQLException ex) {
            System.err.println("Erro na criação do banco! " + ex.getMessage());
        }
    }
}
