/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.model.dao;

import safekey.model.bean.AcessoSuporte;
import safekey.util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import safekey.model.bean.Suporte;

/**
 *
 * @author User
 */
public class DaoSuporte {

    private final Connection c;

    public DaoSuporte() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public Suporte inserir(Suporte sup) throws SQLException {

        String sql = "INSERT INTO suporte "+"(idSuporte,mtFun,nmFun,setorFun,nivelFun,cargoFun,idContatoFunc,dtcontratado,idEmpresa)"+" VALUES (?,?,?,?,?,?,?,?,?)";

        // seta os valores
        try ( // prepared statement para inserção
                 PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, sup.getMt_funcionario());
            stmt.setString(2, sup.getNm_funcinario());
            stmt.setString(3, sup.getSetor());
            stmt.setString(4, sup.getNivel());
            stmt.setString(5, sup.getCargo());
            stmt.setInt(6, sup.getContato().getId_contato());
            stmt.setString(7, sup.getEmpresa().getCnpj());
            stmt.setString(8, sup.getDt_contratado());
            stmt.setString(9, sup.getEmpresa().getCnpj());
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                sup.setId_suporte(id);
            }
        }
        c.close();
        return sup;
    }

    public Suporte buscar(Suporte user) throws SQLException {
        String sql = "SELECT * FROM suporte WHERE mtFun = ?";
        Suporte retorno;
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, user.getMt_funcionario());
            // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            while (rs.next()) {
                // criando o objeto Suporte
                retorno = new Suporte(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8));
            }
        }
        c.close();
        return retorno;
    }

    public List<Suporte> listar(Suporte sup) throws SQLException {
        // usus: array armazena a lista de registros
        List<Suporte> listasup = new ArrayList<>();

        String sql = "SELECT * FROM suporte WHERE nmFun like ?";
        // seta os valores
        try ( PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, "%" + sup.getNm_funcinario()+ "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // criando o objeto AcessoSuporte
                    Suporte pSaida = new Suporte(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getString(8));
                    // adiciona o usu à lista de usus
                    listasup.add(pSaida);
                }
            }
        }
        return listasup;
    }

    public Suporte alterar(Suporte user) throws SQLException {
        String sql = "UPDATE suporte SET mtFun = ?, nmFunc = ? setorFunc = ?, nivelFunc = ? cargoFun = ?, dtContratado = ? WHERE idSuporte = ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, user.getMt_funcionario());
            stmt.setString(2, user.getNm_funcinario());
            stmt.setString(3, user.getSetor());
            stmt.setString(4, user.getNivel());
            stmt.setString(2, user.getCargo());
            stmt.setString(2, user.getDt_contratado());
            stmt.setInt(2, user.getId_suporte());
            
            stmt.execute();
        }
        return user;

    }

    public Suporte excluir(Suporte user) throws SQLException {
        String sql = "DELETE FROM suporte WHERE mtFun = ?";
        // seta os valores
        // prepared statement para inserção
        try ( PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, user.getMt_funcionario());
            // executa
            stmt.execute();
        }
        c.close();
        return user;
    }

}
