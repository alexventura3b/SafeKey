/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.model.dao;

import safekey.model.bean.ClienteLocker;
import safekey.util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexv
 */
public class DaoClienteLocker {

    private final Connection c;

    public DaoClienteLocker() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }
    public ClienteLocker inserir(ClienteLocker clilocker) throws SQLException {
        String sql = "insert into cliente_locker" + " (idContrato,numContrato,idVeículo,idcompartimento,data, hora, obsContrato,idTarifa, statusContrato, idPagamento)" + " values (?,?,?,?,?,?,?,?,?,?)";
        //seta os valores
        try (//prepared statments para inserção
                 PreparedStatement stmt = c.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            //seta os valores

            //stmt.setInt(1, clilocker.getId_contrato());
            stmt.setInt(1, clilocker.getNum_contrato());
            stmt.setString(2, clilocker.getId_veiculo());
            stmt.setInt(3, clilocker.getId_compartimento());
            stmt.setString(4, clilocker.getDt_contrato());
            stmt.setString(5, clilocker.getHora_contrato());
            stmt.setString(6, clilocker.getObs_contrato());
            stmt.setInt(7, clilocker.getId_tarifa());
            stmt.setBoolean(8, clilocker.isStatus_contrato());
            stmt.setInt(9, clilocker.getId_pagamento());
            //executa
            stmt.executeUpdate();
            ResultSet res = stmt.getGeneratedKeys();
            if (res.next()) {
                int id = res.getInt(1);
                clilocker.setId_contrato(id);
            }
            c.close();
        }
        return clilocker;
    }

    public List<ClienteLocker> listar(ClienteLocker clilocker) throws SQLException {
        List<ClienteLocker> listaCV = new ArrayList<>();

        String sql = "select * from cliente_locker where placa like ?";
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, "%" + clilocker.getId_veiculo() + "%");

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                // criando o objeto Usuario
                ClienteLocker cvSaida = new ClienteLocker(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5));
                listaCV.add(cvSaida);
            }
            res.close();
        }
        return listaCV;
    }

    public ClienteLocker buscar(ClienteLocker clilocker) throws SQLException {
        String ticket = "" + clilocker.getId_contrato();
        System.out.println("ticket: " + ticket + "- valor do get: " + clilocker.getId_contrato());
        String sql = "select * from cliente_locker WHERE ticket = ?";
        ClienteLocker retorno;
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1, clilocker.getId_contrato());
            // executa
            ResultSet result = stmt.executeQuery();
            retorno = null;
            while (result.next()) {
                // criando o objeto Usuario
                retorno = new ClienteLocker(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));

                // adiciona o usu à lista de pessoa
            }
        }
        c.close();
        return retorno;
    }

    public ClienteLocker alterar(ClienteLocker clilocker) throws SQLException {
        String sql = "UPDATE cliente_locker SET  idVeiculo=?, idCompartimento= ?, data=?, hora=?, obsContrato=?, idTarifa=?, statusContrato=?, idPagamento=? WHERE numContrato = ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            
            stmt.setString(1, clilocker.getId_veiculo());
            stmt.setInt(2, clilocker.getId_compartimento());
            stmt.setString(3, clilocker.getDt_contrato());
            stmt.setString(4, clilocker.getHora_contrato());
            stmt.setString(5, clilocker.getObs_contrato());
            stmt.setInt(6, clilocker.getId_tarifa());
            stmt.setInt(7, clilocker.getId_pagamento());
            stmt.setInt(8, clilocker.getNum_contrato());
            // executa
            stmt.execute();
        }
        return clilocker;
    }

    public ClienteLocker excluir(ClienteLocker clilocker) throws SQLException {
        String sql = "DELETE FROM cliente_locker WHERE numContrato = ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1, clilocker.getId_contrato());
            // executa
            stmt.execute();
        }
        return clilocker;
    }
}
