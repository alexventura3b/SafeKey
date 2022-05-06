/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.controller;

import safekey.model.bean.Veiculo;
import safekey.model.dao.DaoVeiculo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alexv
 */
public class ControleVeiculo {

    static DaoVeiculo daoveic;

    public ControleVeiculo() throws SQLException, ClassNotFoundException {
        daoveic = new DaoVeiculo();
    }

    public Veiculo inserir(Veiculo veic) throws SQLException {
        return daoveic.inserir(veic);
    }

    public List<Veiculo> listar(Veiculo veic) throws SQLException {
        return daoveic.listar(veic);
    }

    public Veiculo buscar(Veiculo veic) throws SQLException {
        return daoveic.buscar(veic);
    }

    public Veiculo alterar(Veiculo veic) throws SQLException {
        return daoveic.alterar(veic);
    }

    public Veiculo excluir(Veiculo veic) throws SQLException {
        return daoveic.excluir(veic);
    }

}
