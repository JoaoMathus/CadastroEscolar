package acesso_banco;

import classes_base.Professor;

import java.sql.SQLException;

public class ProfessorDAO extends DAOAbstrato <Professor, Integer> {
    protected final String scriptTabela = "CREATE TABLE IF NOT EXISTS professor (\n" +
            "    idprofessor INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    nome TEXT,\n" +
            "    cpf TEXT,\n" +
            "    telefone TEXT,\n" +
            "    celular TEXT,\n" +
            "    datanascimento TEXT\n" +
            ")";

    public ProfessorDAO() {
        criarTabela();
    }

    @Override
    protected void criarTabela() {
        try {
            var stmt = conectar().createStatement();
            stmt.execute(scriptTabela);
            fecharStatement(stmt);
        } catch (SQLException ex) {
            System.err.println("Erro na criação da tabela professor: " + ex.getMessage());
        }
    }

    public void inserir(String nome, String cpf, String telefone, String celular,
                        String dataNascimento) {
        try {
            var stmt = conectar().prepareStatement("INSERT INTO professor (" +
                    "nome, cpf, telefone, celular, datanascimento) VALUES (" +
                    "?, ?, ?, ?, ?)");
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            stmt.setString(4, celular);
            stmt.setString(5, dataNascimento);
            stmt.executeUpdate();
            fecharStatement(stmt);
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir professor: " + ex.getMessage());
        }
    }

    @Override
    public void deletar(Integer idprofessor) {
        try {
            var stmt = conectar().prepareStatement("DELETE FROM professor WHERE idprofessor = ?");
            stmt.setInt(1, idprofessor);
            stmt.executeUpdate();
            fecharStatement(stmt);
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar professor: " + ex.getMessage());
        }
    }

    @Override
    public void alterar(Professor p) {
        try {
            var stmt = conectar().prepareStatement("UPDATE professor SET nome = ?, " +
                    "cpf = ?, telefone = ?, celular = ?, datanascimento = ? " +
                    "WHERE idprofessor = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getTelefone());
            stmt.setString(4, p.getCelular());
            stmt.setString(5, p.getDataNascimento());
            stmt.setInt(6, p.getId());

            stmt.executeUpdate();
            fecharStatement(stmt);
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar professor: " + ex.getMessage());
        }
    }
}
