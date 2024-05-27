package acesso_banco;

import classes_base.Professor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO extends DAOAbstrato <Professor, Integer> {
    protected final String scriptTabela = "CREATE TABLE IF NOT EXISTS professor (\n" +
            "    idprofessor INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    nome TEXT,\n" +
            "    cpf TEXT,\n" +
            "    telefone TEXT,\n" +
            "    datanascimento TEXT\n" +
            ")";
    private final String insertSql = "INSERT INTO professor (" +
            "nome, cpf, telefone, datanascimento) VALUES (" +
            "?, ?, ?, ?)";
    private final String deleteSql = "DELETE FROM professor WHERE idprofessor = ?";
    private final String updateSql = "UPDATE professor SET nome = ?, " +
            "cpf = ?, telefone = ?, datanascimento = ? " +
            "WHERE idprofessor = ?";
    private final String selectSql = "SELECT * FROM professor WHERE idprofessor = ?";
    private final String selectAllSql = "SELECT * FROM professor";

    public ProfessorDAO() {
        criarTabela();
    }

    @Override
    protected void criarTabela() {
        try (var stmt = conectar().createStatement()) {
            stmt.execute(scriptTabela);
        } catch (SQLException ex) {
            System.err.println("Erro na criação da tabela professor: " + ex.getMessage());
        }
    }

    public void inserir(String nome, String cpf, String telefone, String dataNascimento) {
        // Ver se o professor já está no banco
        var professores = selecionarTodos();
        for (var professor : professores) {
            if (professor.getNome().equals(nome) && professor.getCpf().equals(cpf) &&
            professor.getDataNascimento().equals(dataNascimento))
                return ;
        }
        try (var stmt = conectar().prepareStatement(insertSql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            stmt.setString(4, dataNascimento);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir professor: " + ex.getMessage());
        }
    }

    @Override
    public void deletar(Integer idprofessor) {
        try (var stmt = conectar().prepareStatement(deleteSql)) {
            stmt.setInt(1, idprofessor);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar professor: " + ex.getMessage());
        }
    }

    @Override
    public void alterar(Professor p) {
        try (var stmt = conectar().prepareStatement(updateSql)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getTelefone());
            stmt.setString(4, p.getDataNascimento());
            stmt.setInt(5, p.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar professor: " + ex.getMessage());
        }
    }

    @Override
    public Professor selecionar(Integer id) {
        Professor p = null;

        try (var stmt = conectar().prepareStatement(selectSql)) {
            var r = stmt.executeQuery();
            while (r.next()) {
                p = new Professor(r.getInt("idprofessor"), r.getString("nome"),
                        r.getString("cpf"), r.getString("telefone"),
                        r.getString("datanascimento"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar professor: " + ex.getMessage());
        }
        return p;
    }

    @Override
    public List<Professor> selecionarTodos() {
        List<Professor> lista = new ArrayList<>();
        try (var stmt = conectar().createStatement()) {
            var r = stmt.executeQuery(selectAllSql);
            while (r.next()) {
                lista.add(new Professor(r.getInt("idprofessor"), r.getString("nome"),
                        r.getString("cpf"), r.getString("telefone"),
                        r.getString("datanascimento")));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar todos os professores: " + ex.getMessage());
        }
        return lista;
    }
}
