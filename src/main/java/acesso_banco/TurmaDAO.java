package acesso_banco;

import classes_base.Turma;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO extends DAOAbstrato <Turma, Integer> {
    private final String scriptTabela = "CREATE TABLE IF NOT EXISTS turma (\n" +
            "    idturma INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    capacidade INTEGER,\n" +
            "    serie TEXT,\n" +
            "    numero TEXT,\n" +
            "    fk_idprofessor INTEGER,\n" +
            "    FOREIGN KEY (fk_idprofessor) REFERENCES professor(idprofessor)\n" +
            ")";

    public TurmaDAO() {
        criarTabela();
    }

    @Override
    protected void criarTabela() {
        try (var stmt = conectar().createStatement();) {
            stmt.execute(scriptTabela);
        } catch (SQLException ex) {
            System.err.println("Erro ao criar tabela turma: " + ex.getMessage());
        }
    }

    public void inserir(int capacidade, String serie, String numero, int professorId) {
        try (var stmt = conectar().prepareStatement("INSERT INTO turma (" +
                "capacidade, serie, numero, fk_idprofessor) VALUES (" +
                "?, ?, ?, ?)")) {
            stmt.setInt(1, capacidade);
            stmt.setString(2, serie);
            stmt.setString(3, numero);
            stmt.setInt(4, professorId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir turma: " + ex.getMessage());
        }
    }

    @Override
    public void deletar(Integer id) {
        try (var stmt = conectar().prepareStatement("DELETE FROM turma WHERE idturma = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar turma: " + ex.getMessage());
        }
    }

    @Override
    public void alterar(Turma t) {
        try (var stmt = conectar().prepareStatement("UPDATE turma SET capacidade = ?, " +
                "serie = ?, numero = ?, fk_idprofessor = ? WHERE idturma = ?")) {
            stmt.setInt(1, t.getCapacidade());
            stmt.setString(2, t.getSerie());
            stmt.setString(3, t.getNumero());
            stmt.setInt(4, t.getIdProfessor());
            stmt.setInt(5, t.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar turma: " + ex.getMessage());
        }
    }

    @Override
    public Turma selecionar(Integer id) {
        Turma t = null;

        try (var stmt = conectar().prepareStatement("SELECT * FROM turma WHERE idturma = ?")) {
            stmt.setInt(1, id);
            var r = stmt.executeQuery();
            while (r.next()) {
                // TODO: dar set() nos alunos e no professor da turma...
                t = new Turma(r.getInt("idturma"), r.getString("numero"),
                        r.getString("serie"), r.getInt("capacidade"),
                        r.getInt("fk_idprofessor"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar turma: " + ex.getMessage());
        }
        return t;
    }

    @Override
    public List<Turma> selecionarTodos() {
        List<Turma> lista = new ArrayList<>();

        try (var stmt = conectar().prepareStatement("SELECT * FROM turma")) {
            var r = stmt.executeQuery();

            while (r.next()) {
                lista.add(new Turma(r.getInt("idturma"), r.getString("numero"),
                        r.getString("serie"), r.getInt("capacidade"),
                        r.getInt("fk_idprofessor")));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar todas as turmas: " + ex.getMessage());
        }
    }
}
