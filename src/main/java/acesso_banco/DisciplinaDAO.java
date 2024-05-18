package acesso_banco;

import classes_base.Disciplina;

import java.sql.SQLException;

public class DisciplinaDAO extends DAOAbstrato <Disciplina, Integer> {
    private final String scriptTabela = "CREATE TABLE IF NOT EXISTS disciplina (\n" +
            "    iddisciplina INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    av1 REAL,\n" +
            "    av2 REAL,\n" +
            "    media REAL,\n" +
            "    nome TEXT,\n" +
            "    fk_idaluno INTEGER,\n" +
            "    FOREIGN KEY (fk_idaluno) REFERENCES aluno(idaluno)\n" +
            ")";

    public DisciplinaDAO() {
        criarTabela();
    }

    @Override
    protected void criarTabela() {
        try {
            var stmt = conectar().createStatement();
            stmt.execute(scriptTabela);
            fecharStatement(stmt);
        } catch (SQLException ex) {
            System.err.println("Erro ao criar tabela disciplina: " + ex.getMessage());
        }
    }

    public void inserir(float av1, float av2, float media, String nome, int idaluno) {
        try {
            var stmt = conectar().prepareStatement("INSERT INTO disciplina (" +
                    "av1, av2, media, nome, fk_idaluno) VALUES (" +
                    "?, ?, ?, ?, ?)");
            stmt.setFloat(1, av1);
            stmt.setFloat(2, av2);
            stmt.setFloat(3, media);
            stmt.setString(4, nome);
            stmt.setInt(5, idaluno);

            stmt.executeUpdate();
            fecharStatement(stmt);
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir disciplina: " + ex.getMessage());
        }
    }

    @Override
    public void deletar(Integer id) {
        try {
            var stmt = conectar().prepareStatement("DELETE FROM disciplina WHERE iddisciplina = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            fecharStatement(stmt);
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar disciplina: " + ex.getMessage());
        }
    }

    @Override
    public void alterar(Disciplina d) {
        try {
            var stmt = conectar().prepareStatement("UPDATE disciplina SET av1 = ?," +
                    "av2 = ?, media = ?, nome = ?, fk_idaluno = ? WHERE iddisciplina = ?)");
            stmt.setFloat(1, d.getAv1());
            stmt.setFloat(2, d.getAv2());
            stmt.setFloat(3, d.getMedia());
            stmt.setString(4, d.getNome());
            stmt.setInt(5, d.getIdaluno());
            stmt.setInt(6, d.getId());

            stmt.executeUpdate();
            fecharStatement(stmt);
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar disciplina: " + ex.getMessage());
        }
    }
}
