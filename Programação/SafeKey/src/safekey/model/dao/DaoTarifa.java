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

/**
 *
 * @author alexv
 */
public class DaoTarifa {

    private final Connection c;

    public DaoTarifa() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public Cliente inserir(Cliente cli) throws SQLException {
        String sql = "insert into clientes" + " (nome,cpf,idcontato,dtcadastro)" + " values (?,?,?,?)";
    
        // seta os valores
        try ( // prepared statement para inserção
                 PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, cli.getNm_cliente());
            stmt.setString(2, cli.getCpf_cliente());
            stmt.setInt(3, cli.getId_Contatos());// * deve ter sido gerado o id de contato antes desta passagem de parametros
            stmt.setString(4,cli.getDt_cadastro());
            // executa
            stmt.executeUpdate();
            ResultSet result = stmt.getGeneratedKeys();
            if (result.next()) {
                int id = result.getInt(1);
                cli.setId_cliente(id);
            }
            c.close();
        }

        return cli;
    }

    public List<Cliente> listar(Cliente cli) throws SQLException {
        List<Cliente> listaCliente = new ArrayList<>();

        String sql = "SELECT * FROM clientes WHERE nmcliente LIKE ?";
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, "%" + cli.getNm_cliente()+ "%");

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                // criando o objeto Usuario
                Cliente liSaida = new Cliente(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),//não é preciso mostrar id_contato apenas anexar end e tell dos respectivos;(editar)
                        result.getString(5));
                // adiciona o usu à lista
                listaCliente.add(liSaida);
            }

            result.close();
        }
        return listaCliente;
    }

    public Cliente buscar(Cliente cli) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE cpfCliente = ?";
        Cliente retorno;
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, cli.getCpf_cliente());
            // executa
            ResultSet result = stmt.executeQuery();
            retorno = null;
            while (result.next()) {
                // criando o objeto Cliente
                retorno = new Cliente(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5));

                // adiciona o usu à lista de pessoa
            }
        }
        c.close();
        return retorno;
    }

    public Cliente alterar(Cliente cli) throws SQLException {
        String sql = "UPDATE clientes SET nmCliente = ?,cpfCliente = ?  WHERE idCliente = ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, cli.getNm_cliente());
            stmt.setString(2, cli.getCpf_cliente());
            // executa
            stmt.execute();
        }
        c.close();
        return cli;
    }

    public Cliente excluir(Cliente cli) throws SQLException {
        String sql = "DELETE FROM clientes WHERE idCliente= ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, cli.getCpf_cliente());
            // executa
            stmt.execute();
        }
        c.close();
        return cli;
    }
}
