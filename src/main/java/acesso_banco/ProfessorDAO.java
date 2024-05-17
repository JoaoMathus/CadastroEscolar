package acesso_banco;

public class ProfessorDAO {
    private final String scriptTabela = "CREATE TABLE IF NOT EXISTS professor (\n" +
            "    idprofessor INTEGER PRIMARY KEY,\n" +
            "    nome TEXT,\n" +
            "    cpf TEXT,\n" +
            "    telefone TEXT,\n" +
            "    celular TEXT,\n" +
            "    datanascimento TEXT\n" +
            ")";
}
