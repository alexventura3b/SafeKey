/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.model.dao;

import safekey.util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import safekey.model.bean.AcessoCliente;
import safekey.model.bean.AcessoSuporte;

/**
 *
 * @author alexv
 */
public class DaoAcessoCliente {

    private final Connection c;

    public DaoAcessoCliente() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public AcessoCliente inserir(AcessoCliente acli) throws SQLException {
        String sql = "INSERT INTO acesso_clientes" + " (id_cliente,usuario,senha,datacriacao)" + " values (?,?,?,?)";
    
        // seta os valores
        try ( // prepared statement para inserção
                 PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, acli.getId_cliente());
            stmt.setString(2, acli.getSenha());
            stmt.setString(3, acli.getSenha());// * deve ter sido gerado o id de contato antes desta passagem de parametros
            stmt.setString(4,acli.getDt_criacao());
            // executa
            stmt.executeUpdate();
            ResultSet result = stmt.getGeneratedKeys();
            if (result.next()) {
                int id = result.getInt(1);
                acli.setId_acesso(id);
            }
            c.close();
        }

        return acli;
    }

    public List<AcessoCliente> listar(AcessoCliente acli) throws SQLException {
        List<AcessoCliente> listadeacessos = new ArrayList<>();

        String sql = "SELECT * FROM acesso_clientes WHERE usuario LIKE ?";
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, "%" + acli.getUsuario()+ "%");

            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    // criando o objeto Usuario
                    AcessoCliente liSaida = new AcessoCliente(
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),//teste  (mostrando senha)
                            result.getString(4),
                            result.getString(5));
                    // adiciona o usu à lista
                    listadeacessos.add(liSaida);
                }
            }
        }
        return listadeacessos;
    }

    public AcessoCliente buscar(AcessoCliente acli) throws SQLException {
        String sql = "SELECT * FROM acesso_clientes WHERE id_cliente = ?";
        AcessoCliente retorno;
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, acli.getId_cliente());
            // executa
            ResultSet result = stmt.executeQuery();
            retorno = null;
            while (result.next()) {
                // criando o objeto AcessoCliente
                retorno = new AcessoCliente(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));

            }
        }
        c.close();
        return retorno;
    }

    public AcessoCliente alterar(AcessoCliente acli) throws SQLException {
        String sql = "UPDATE acesso_clientes SET usuario = ?,senha = ?  WHERE idcliente = ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, acli.getUsuario());
            stmt.setString(2, acli.getSenha());
            stmt.setString(3, acli.getId_cliente());
            // executa
            stmt.execute();
        }
        c.close();
        return acli;
    }

    public AcessoCliente excluir(AcessoCliente acli) throws SQLException {
        String sql = "DELETE FROM acesso_clientes WHERE idcliente= ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, acli.getId_cliente());
            // executa
            stmt.execute();
        }
        c.close();
        return acli;
    }

    public AcessoCliente valida(AcessoSuporte acli) throws SQLException {
    String sql = "SELECT * FROM acesso_clientes WHERE usuario = ? AND senha = ?";
    AcessoCliente retorno;
    // seta os valores
    try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
        // seta os valores
        stmt.setString(1, acli.getUsuario());
        stmt.setString(2, acli.getSenha());
        // executa
        ResultSet rs = stmt.executeQuery();
        retorno = null;
        while (rs.next()) {
            // criando o objeto AcessoSuporte
            retorno = new AcessoCliente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de pessoa
        }
    }
    c.close();
    return retorno;
    }
}
