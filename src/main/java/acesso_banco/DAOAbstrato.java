package acesso_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DAOAbstrato <E, K> {
    protected final String caminhoBanco = "dados.sqlite";
    protected String scriptTabela;

    protected Connection conectar() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + caminhoBanco);
    }

    protected void fecharStatement(Statement stmt) throws SQLException {
        stmt.getConnection().close();
    }

    protected abstract void criarTabela();

    public abstract void inserir(E entidade);
    public abstract void deletar(K chave);
    public abstract void alterar(E entidade);
    public abstract E selecionar(K chave);
    public abstract List<E> selecionarTodos();
}
