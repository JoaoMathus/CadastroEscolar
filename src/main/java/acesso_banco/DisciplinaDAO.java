package acesso_banco;

import classes_base.Disciplina;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO extends DAOAbstrato <Disciplina, Integer> {
    private final String scriptTabela = "CREATE TABLE disciplina (\n" +
            "    iddisciplina INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    nome TEXT,\n" +
            "    prova1 REAL,\n" +
            "    prova2 REAL,\n" +
            "    media REAL,\n" +
            "    anoletivo TEXT,\n" +
            "    aprovado INTEGER,\n" +
            "    fk_idaluno INTEGER,\n" +
            "    FOREIGN KEY(fk_idaluno) REFERENCES aluno(idaluno)\n" +
            ")";
    private final String insertSql = "INSERT INTO disciplina (" +
            "nome, prova1, prova2, media, anoletivo, aprovado, fk_idaluno) VALUES (" +
            "?, ?, ?, ?, ?, ?, ?, ?)";
    private final String deleteSql = "DELETE FROM disciplina WHERE iddisciplina = ?";
    private final String updateSql = "UPDATE disciplina SET nome = ?," +
            "prova1 = ?, prova2 = ?, media = ?, " +
            "anoletivo = ?, aprovado = ?, fk_idaluno = ? WHERE iddisciplina = ?)";
    private final String selectSql = "SELECT * FROM disciplina WHERE iddisciplina = ?";
    private final String selectAllSql = "SELECT * FROM disciplina";

    public DisciplinaDAO() {
        criarTabela();
    }

    @Override
    protected void criarTabela() {
        try (var stmt = conectar().createStatement()) {
            stmt.execute(scriptTabela);
        } catch (SQLException ex) {
            System.err.println("Erro ao criar tabela disciplina: " + ex.getMessage());
        }
    }

    public void inserir(String nome, String bimestre, float av1, float av2, float media,
                        String anoLetivo, boolean aprovado, int idAluno) {
        try (var stmt = conectar().prepareStatement(insertSql)) {
            stmt.setString(1, nome);
            stmt.setString(2, bimestre);
            stmt.setFloat(3, av1);
            stmt.setFloat(4, av2);
            stmt.setFloat(5, media);
            stmt.setString(6, anoLetivo);
            stmt.setBoolean(7, aprovado);
            stmt.setInt(8, idAluno);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir disciplina: " + ex.getMessage());
        }
    }

    @Override
    public void deletar(Integer id) {
        try (var stmt = conectar().prepareStatement(deleteSql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar disciplina: " + ex.getMessage());
        }
    }

    @Override
    public void alterar(Disciplina d) {
        try (var stmt = conectar().prepareStatement(updateSql)) {
            stmt.setString(1, d.getNome());
            stmt.setFloat(2, d.getAv1());
            stmt.setFloat(3, d.getAv2());
            stmt.setFloat(4, d.getMedia());
            stmt.setString(5, d.getAnoLetivo());
            stmt.setBoolean(6, d.isAprovado());
            stmt.setInt(7, d.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar disciplina: " + ex.getMessage());
        }
    }

    @Override
    public Disciplina selecionar(Integer id) {
        Disciplina d = null;

        try (var stmt = conectar().prepareStatement(selectSql)) {
            stmt.setInt(1, id);
            var r = stmt.executeQuery();
            while (r.next()) {
                d = new Disciplina(r.getInt("iddisciplina"), r.getString("nome"),
                        r.getFloat("prova1"), r.getFloat("prova2"),
                        r.getFloat("media"), r.getString("anoletivo"),
                        r.getBoolean("aprovado"), r.getInt("fk_idaluno"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar disciplina: " + ex.getMessage());
        }
        return d;
    }

    @Override
    public List<Disciplina> selecionarTodos() {
        List<Disciplina> lista = new ArrayList<>();

        try (var stmt = conectar().createStatement()) {
            var r = stmt.executeQuery(selectAllSql);
            while (r.next()) {
                lista.add(new Disciplina(r.getInt("iddisciplina"),
                        r.getString("nome"), r.getFloat("prova1"),
                        r.getFloat("prova2"), r.getFloat("media"),
                        r.getString("anoletivo"), r.getBoolean("aprovado"),
                        r.getInt("fk_idaluno")));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar todas as disciplinas: " + ex.getMessage());
        }
        return lista;
    }
}
