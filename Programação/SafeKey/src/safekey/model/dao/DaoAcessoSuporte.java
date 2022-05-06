/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.model.dao;

import safekey.model.bean.Cliente;
import safekey.util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import safekey.model.bean.AcessoSuporte;

/**
 *
 * @author alexv
 */
public class DaoAcessoSuporte {

    private final Connection c;

    public DaoAcessoSuporte() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public AcessoSuporte inserir(AcessoSuporte cli) throws SQLException {
        String sql = "INSERT INTO acesso_funcionario" + " (idacesso,idfun,usuario,senha,datacriacao)" + " VALUES (?,?,?,?,?)";
    
        // seta os valores
        try ( // prepared statement para inserção
                 PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, cli.getId_func());
            stmt.setString(2, cli.getUsuario());
            stmt.setString(3, cli.getSenha());
            stmt.setString(4,cli.getDt_criacao());
            // executa
            stmt.executeUpdate();
            ResultSet result = stmt.getGeneratedKeys();
            if (result.next()) {
                int id = result.getInt(1);
                cli.setIdacesso(id);
            }
            c.close();
        }

        return cli;
    }

    public List<AcessoSuporte> listar(AcessoSuporte cli) throws SQLException {
        List<AcessoSuporte> listaCliente = new ArrayList<>();

        String sql = "SELECT * FROM acesso_funcionario WHERE usuario LIKE ?";
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, "%" + cli.getUsuario()+ "%");

            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    // criando o objeto Usuario
                    AcessoSuporte liSaida = new AcessoSuporte(
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),//não é preciso mostrar id_contato apenas anexar end e tell dos respectivos;(editar)
                            result.getString(5));
                    // adiciona o usu à lista
                    listaCliente.add(liSaida);
                }
            }
        }
        return listaCliente;
    }

    public AcessoSuporte buscar(AcessoSuporte cli) throws SQLException {
        String sql = "SELECT * FROM acesso_funcionario WHERE idfun = ?";
        AcessoSuporte retorno;
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, cli.getId_func());
            // executa
            ResultSet result = stmt.executeQuery();
            retorno = null;
            while (result.next()) {
                // criando o objeto Cliente
                retorno = new AcessoSuporte(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));

                // adiciona o usu à lista de pessoa
            }
        }
        c.close();
        return retorno;
    }

    public AcessoSuporte alterar(AcessoSuporte cli) throws SQLException {
        String sql = "UPDATE acesso_funcionario SET usuario = ?,senha = ?  WHERE idfun = ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, cli.getUsuario());
            stmt.setString(2, cli.getSenha());
            stmt.setString(3,cli.getId_func());
            // executa
            stmt.execute();
        }
        c.close();
        return cli;
    }

    public AcessoSuporte excluir(AcessoSuporte asup) throws SQLException {
        String sql = "DELETE FROM acesso_funcionario WHERE idCliente= ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, asup.getId_func());
            // executa
            stmt.execute();
        }
        c.close();
        return asup;
    }
}
