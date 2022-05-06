/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.model.dao;

import safekey.model.bean.Veiculo;
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
public class DaoVeiculo {

    private final Connection c;

    public DaoVeiculo() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public Veiculo inserir(Veiculo veic) throws SQLException {
        String sql = "insert into veiculo" + " (placa, ano_fabr, marca, modelo, cor)" + " values (?,?,?,?,?)";

        // seta os valores
        try ( // prepared statement para inserção
                 PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, veic.getPlaca());
            stmt.setString(2, veic.getAno_fabr());
            stmt.setString(3, veic.getMarca());
            stmt.setString(4, veic.getModelo());
            stmt.setString(5, veic.getCor());

            // executa
            stmt.executeUpdate();
//            ResultSet result = stmt.getGeneratedKeys();
//            if (result.next()) {
//                int id = result.getInt(1);
//                cli.setId_veiculo(id);
//            }
            c.close();
        }
        return veic;
    }

    public List<Veiculo> listar(Veiculo veic) throws SQLException {
        List<Veiculo> listaV = new ArrayList<>();

        String sql = "select * from veiculo where placa like ?";
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, "%" + veic.getPlaca() + "%");

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                // criando o objeto Usuario
                Veiculo veicSaida = new Veiculo(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                // adiciona o usu à lista de usus
                listaV.add(veicSaida);
            }

            result.close();
        }
        return listaV;
    }

    public Veiculo buscar(Veiculo veic) throws SQLException {
        String sql = "select * from veiculo WHERE placa = ?";
        Veiculo retorno;
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, veic.getPlaca());
            // executa
            ResultSet result = stmt.executeQuery();
            retorno = null;
            while (result.next()) {
                // criando o objeto Usuario
                retorno = new Veiculo(
                        result.getString(1),
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

    public Veiculo alterar(Veiculo veic) throws SQLException {
        String sql = "UPDATE veiculo SET ano_fabr = ?, marca=?, modelo=?, cor=?  WHERE placa = ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, veic.getAno_fabr());
            stmt.setString(2, veic.getMarca());
            stmt.setString(3, veic.getModelo());
            stmt.setString(4, veic.getCor());
            stmt.setString(5, veic.getPlaca());

            // executa
            stmt.execute();
        }
        c.close();
        return veic;
    }

    public Veiculo excluir(Veiculo veic) throws SQLException {
        String sql = "delete from veiculo WHERE placa = ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, veic.getPlaca());
            // executa
            stmt.execute();
        }
        c.close();
        return veic;
    }
}
