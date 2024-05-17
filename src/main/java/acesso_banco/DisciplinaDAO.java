package acesso_banco;

public class DisciplinaDAO {
    private final String scriptTabela = "CREATE TABLE IF NOT EXISTS disciplina (\n" +
            "    iddisciplina INTEGER PRIMARY KEY,\n" +
            "    av1 REAL,\n" +
            "    av2 REAL,\n" +
            "    media REAL,\n" +
            "    nome TEXT,\n" +
            "    fk_idaluno INTEGER,\n" +
            "    FOREIGN KEY (fk_idaluno) REFERENCES aluno(idaluno)\n" +
            ")";
}
