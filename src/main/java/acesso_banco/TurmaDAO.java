package acesso_banco;

public class TurmaDAO {
    private final String scriptTabela = "CREATE TABLE IF NOT EXISTS turma (\n" +
            "    idturma INTEGER PRIMARY KEY,\n" +
            "    capacidade INTEGER,\n" +
            "    serie TEXT,\n" +
            "    numero TEXT,\n" +
            "    fk_idprofessor INTEGER,\n" +
            "    FOREIGN KEY (fk_idprofessor) REFERENCES professor(idprofessor)\n" +
            ")";
}
