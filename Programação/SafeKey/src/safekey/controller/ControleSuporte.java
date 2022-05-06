/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.controller;

import safekey.model.dao.DaoSuporte;
import java.sql.SQLException;
import java.util.List;
import safekey.model.bean.Suporte;

/**
 *
 * @author User
 */
public class ControleSuporte {

    static DaoSuporte daosup;

    public ControleSuporte() throws SQLException, ClassNotFoundException {
        daosup = new DaoSuporte();
    }

    public Suporte inserir(Suporte sup) throws SQLException {
        return daosup.inserir(sup);
    }

    public List<Suporte> listar(Suporte sup) throws SQLException {
        return daosup.listar(sup);
    }

    public Suporte buscar(Suporte sup) throws SQLException {
        return daosup.buscar(sup);
    }

    public Suporte alterar(Suporte sup) throws SQLException {
        return daosup.alterar(sup);
    }

    public Suporte excluir(Suporte sup) throws SQLException {
        return daosup.excluir(sup);
    }

    public Suporte valida(Suporte sup) throws SQLException {
        return daosup.valida(sup);
    }

}
