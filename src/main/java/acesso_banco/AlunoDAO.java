package acesso_banco;

import classes_base.Aluno;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends DAOAbstrato <Aluno, Integer> {
    protected final String scriptTabela = "CREATE TABLE IF NOT EXISTS aluno (\n" +
            "    idaluno INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    nome TEXT,\n" +
            "    datanascimento TEXT,\n" +
            "    matricula TEXT,\n" +
            "    telefone TEXT,\n" +
            "    celular TEXT,\n" +
            "    cpfdoresponsavel TEXT,\n" +
            "    tiposanguineo TEXT,\n" +
            "    serie TEXT,\n" +
            "    aprovado INTEGER,\n" +
            "    fk_idturma INTEGER,\n" +
            "    FOREIGN KEY (fk_idturma) REFERENCES turma(idturma)\n" +
            ")";

    public AlunoDAO() {
        criarTabela();
    }

    @Override
    protected void criarTabela() {
        try (var stmt = conectar().createStatement()) {
            stmt.execute(scriptTabela);
        } catch (SQLException ex) {
            System.err.println("Erro na criação da tabela aluno: " + ex.getMessage());
        }
    }

    public void inserir(String nome, String dataNascimento, String matricula,
                        String telefone, String celular, String cpfDoResponsavel,
                        String tipoSanguineo, String serie, int idturma) {
        try (var stmt = conectar().prepareStatement("INSERT INTO aluno (" +
                "nome, datanascimento, matricula, telefone, celular, cpfdoresponsavel, " +
                "tiposanguineo, serie, aprovado, fk_idturma) VALUES (?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, nome);
            stmt.setString(2, dataNascimento);
            stmt.setString(3, matricula);
            stmt.setString(4, telefone);
            stmt.setString(5, celular);
            stmt.setString(6, cpfDoResponsavel);
            stmt.setString(7, tipoSanguineo);
            stmt.setString(8, serie);
            stmt.setBoolean(9, false); // obviante não está aprovado ainda
            stmt.setInt(10, idturma);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro na inserção de aluno: " + ex.getMessage());
        }
    }

    @Override
    public void deletar(Integer id) {
        try (var stmt = conectar().prepareStatement("DELETE FROM aluno WHERE " +
                "idaluno = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro em deletar aluno: " + ex.getMessage());
        }
    }

    @Override
    public void alterar(Aluno a) {
        try (var stmt = conectar().prepareStatement("UPDATE aluno " +
                "SET nome = ?," +
                "datanascimento = ?," +
                "matricula = ?," +
                "telefone = ?," +
                "celular = ?," +
                "cpfdoresponsavel = ?," +
                "tiposanguineo = ?," +
                "serie = ?," +
                "aprovado = ?," +
                "fk_idturma = ? " +
                "WHERE idaluno = ?")) {
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getDataNascimento());
            stmt.setString(3, a.getMatricula());
            stmt.setString(4, a.getTelefone());
            stmt.setString(5, a.getCelular());
            stmt.setString(6, a.getCpfDoResponsavel());
            stmt.setString(7, a.getTipoSanguineo());
            stmt.setString(8, a.getTipoSanguineo());
            stmt.setString(9, a.getSerie());
            stmt.setBoolean(10, a.isAprovado());
            stmt.setInt(11, a.getIdTurma());
            stmt.setInt(12, a.getId());
        } catch (SQLException ex) {
            System.err.println("Erro atualizando o aluno: " + ex.getMessage());
        }
    }

    @Override
    public Aluno selecionar(Integer id) {
        Aluno a = null;
        try (var stmt = conectar().prepareStatement("SELECT * FROM aluno WHERE idaluno = ?")) {
            stmt.setInt(1, id);
            var r = stmt.executeQuery();
            while (r.next()) {
                a = new Aluno(r.getInt("idaluno"), r.getString("nome"),
                        r.getString("telefone"), r.getString("celular"),
                        r.getString("datanascimento"), r.getString("matricula"),
                        r.getString("serie"), r.getInt("fk_idturma"),
                        r.getString("tiposanguineo"), r.getString("cpfdoresponsavel"),
                        r.getBoolean("aprovado"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar aluno: " + ex.getMessage());
        }

        return a;
    }

    @Override
    public List<Aluno> selecionarTodos() {
        List<Aluno> lista = new ArrayList<>();

        try (var stmt = conectar().createStatement()) {
            var r = stmt.executeQuery("SELECT * FROM aluno");

            while (r.next()) {
                lista.add(new Aluno(r.getInt("idaluno"), r.getString("nome"),
                        r.getString("telefone"), r.getString("celular"),
                        r.getString("datanascimento"), r.getString("matricula"),
                        r.getString("serie"), r.getInt("fk_idturma"),
                        r.getString("tiposanguineo"), r.getString("cpfdoresponsavel"),
                        r.getBoolean("aprovado")));
            }
        } catch (SQLException ex) {
            System.err.println("Erro em selecionar todos os alunos: " + ex.getMessage());
        }

        return lista;
    }
}
