package acesso_banco;

import classes_base.Disciplina;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO extends DAOAbstrato <Disciplina, Integer> {
    private final String scriptTabela = "CREATE TABLE IF NOT EXISTS disciplina (\n" +
            "    iddisciplina INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    nome TEXT,\n" +
            "    notabimestre1 REAL,\n" +
            "    notabimestre2 REAL,\n" +
            "    notabimestre3 REAL,\n" +
            "    notabimestre4 REAL,\n" +
            "    anoletivo TEXT,\n" +
            "    aprovado INTEGER,\n" +
            "    fk_idaluno INTEGER,\n" +
            "    FOREIGN KEY(fk_idaluno) REFERENCES aluno(idaluno)\n" +
            ")";
    private final String insertSql = "INSERT INTO disciplina (" +
            "nome, notabimestre1, notabimestre2, notabimestre3, notabimestre4, anoletivo, " +
            "aprovado, fk_idaluno) VALUES (" +
            "?, ?, ?, ?, ?, ?, ?, ?)";
    private final String deleteSql = "DELETE FROM disciplina WHERE iddisciplina = ?";
    private final String updateSql = "UPDATE disciplina SET nome = ?," +
            "notabimestre1 = ?, notabimestre2 = ?, notabimestre3 = ?, notabimestre4 = ?, " +
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

    public void inserir(String nome, float notabimestre1, float notabimestre2,
                        float notabimestre3, float notabimestre4,
                        String anoLetivo, boolean aprovado, int idAluno) {
        try (var stmt = conectar().prepareStatement(insertSql)) {
            stmt.setString(1, nome);
            stmt.setFloat(2, notabimestre1);
            stmt.setFloat(3, notabimestre2);
            stmt.setFloat(4, notabimestre3);
            stmt.setFloat(5, notabimestre4);
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
            stmt.setFloat(2, d.getNotaBimestre1());
            stmt.setFloat(3, d.getNotaBimestre2());
            stmt.setFloat(4, d.getNotaBimestre3());
            stmt.setFloat(5, d.getNotaBimestre4());
            stmt.setString(6, d.getAnoLetivo());
            stmt.setBoolean(7, d.isAprovado());
            stmt.setInt(8, d.getIdAluno());
            stmt.setInt(9, d.getId());

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
                        r.getFloat("notabimestre1"), r.getFloat("notabimestre2"),
                        r.getFloat("notabimestre3"), r.getFloat("notabimestre4"),
                        r.getString("anoletivo"),
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
                        r.getString("nome"), r.getFloat("notabimestre1"),
                        r.getFloat("notabimestre2"), r.getFloat("notabimestre3"),
                        r.getFloat("notabimestre4"),
                        r.getString("anoletivo"), r.getBoolean("aprovado"),
                        r.getInt("fk_idaluno")));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar todas as disciplinas: " + ex.getMessage());
        }
        return lista;
    }
}
