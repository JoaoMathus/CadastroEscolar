package acesso_banco;

import classes_base.Aluno;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends DAOAbstrato <Aluno, Integer> {
    private final String scriptTabela = "CREATE TABLE IF NOT EXISTS aluno (\n" +
            "    idaluno INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
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
            ")";
    private final String insertSql = "INSERT INTO aluno (" +
            "nome, datanascimento, matricula, telefone, cpfdoresponsavel, " +
            "tiposanguineo, serie, aprovado, fk_idturma) VALUES (?, " +
            "?, ?, ?, ?, ?, ?, ?, ?)";
    private final String deleteSql = "DELETE FROM aluno WHERE " +
            "idaluno = ?";
    private final String updateSql = "UPDATE aluno " +
            "SET nome = ?," +
            "datanascimento = ?," +
            "matricula = ?," +
            "telefone = ?," +
            "cpfdoresponsavel = ?," +
            "tiposanguineo = ?," +
            "serie = ?," +
            "aprovado = ?," +
            "fk_idturma = ? " +
            "WHERE idaluno = ?";
    private final String selectSql = "SELECT * FROM aluno WHERE idaluno = ?";
    private final String selectAllSql = "SELECT * FROM aluno";


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
                        String telefone, String cpfDoResponsavel,
                        String tipoSanguineo, String serie, int idturma) {
        // Ver se o aluno já está inserido
        var alunos = selecionarTodos();
        for (var aluno : alunos) {
            if (aluno.getMatricula().equals(matricula) && aluno.getIdTurma() == idturma &&
            aluno.getCpfDoResponsavel().equals(cpfDoResponsavel) && aluno.getNome().equals(nome) &&
            aluno.getSerie().equals(serie) && aluno.getTipoSanguineo().equals(tipoSanguineo) &&
            aluno.getDataNascimento().equals(dataNascimento))
                return;
        }
        try (var stmt = conectar().prepareStatement(insertSql)) {
            stmt.setString(1, nome);
            stmt.setString(2, dataNascimento);
            stmt.setString(3, matricula);
            stmt.setString(4, telefone);
            stmt.setString(5, cpfDoResponsavel);
            stmt.setString(6, tipoSanguineo);
            stmt.setString(7, serie);
            stmt.setBoolean(8, false);
            stmt.setInt(9, idturma);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro na inserção de aluno: " + ex.getMessage());
        }
    }

    @Override
    public void deletar(Integer id) {
        try (var stmt = conectar().prepareStatement(deleteSql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro em deletar aluno: " + ex.getMessage());
        }
    }

    @Override
    public void alterar(Aluno a) {
        try (var stmt = conectar().prepareStatement(updateSql)) {
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getDataNascimento());
            stmt.setString(3, a.getMatricula());
            stmt.setString(4, a.getTelefone());
            stmt.setString(5, a.getCpfDoResponsavel());
            stmt.setString(6, a.getTipoSanguineo());
            stmt.setString(7, a.getTipoSanguineo());
            stmt.setString(8, a.getSerie());
            stmt.setBoolean(9, a.isAprovado());
            stmt.setInt(10, a.getIdTurma());
            stmt.setInt(11, a.getId());
        } catch (SQLException ex) {
            System.err.println("Erro atualizando o aluno: " + ex.getMessage());
        }
    }

    @Override
    public Aluno selecionar(Integer id) {
        Aluno a = null;
        try (var stmt = conectar().prepareStatement(selectSql)) {
            stmt.setInt(1, id);
            var r = stmt.executeQuery();
            while (r.next()) {
                a = new Aluno(r.getInt("idaluno"), r.getString("nome"),
                        r.getString("datanascimento"), r.getString("matricula"),
                        r.getString("telefone"), r.getString("cpfdoresponsavel"),
                        r.getString("tiposanguineo"), r.getString("serie"),
                        r.getBoolean("aprovado"), r.getInt("fk_idturma"));
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
            var r = stmt.executeQuery(selectAllSql);

            while (r.next()) {
                lista.add(new Aluno(r.getInt("idaluno"), r.getString("nome"),
                        r.getString("datanascimento"), r.getString("matricula"),
                        r.getString("telefone"), r.getString("cpfdoresponsavel"),
                        r.getString("tiposanguineo"), r.getString("serie"),
                        r.getBoolean("aprovado"), r.getInt("fk_idturma")));
            }
        } catch (SQLException ex) {
            System.err.println("Erro em selecionar todos os alunos: " + ex.getMessage());
        }

        return lista;
    }
}
