/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.controller;

import safekey.model.bean.ClienteLocker;
import safekey.model.bean.Cliente;
import safekey.model.bean.Veiculo;
import safekey.model.dao.DaoClienteLocker;
import java.sql.SQLException;
import java.util.List;
import safekey.model.bean.AcessoSuporte;
import safekey.model.bean.Suporte;
import safekey.model.dao.DaoAcessoSuporte;

/**
 *
 * @author alexv
 */
public class ControleAcessoSuporte {

    static DaoAcessoSuporte daoasup;
    static ControleSuporte contsup;

    public AcessoSuporte inserir(AcessoSuporte acsup) throws SQLException, ClassNotFoundException {
        daoasup = new DaoAcessoSuporte();
        return daoasup.inserir(acsup);
    }

    public List<AcessoSuporte> listar(AcessoSuporte acsup) throws SQLException, ClassNotFoundException {
        daoasup = new DaoAcessoSuporte();
        List<AcessoSuporte> listasup = daoasup.listar(acsup);
        for (AcessoSuporte listasup2 : listasup) {
            contsup = new ControleSuporte();
            Suporte supEntrada = new Suporte(listasup2.getId_func());
            Suporte supSaida = contsup.buscar(supEntrada);
            listasup2.setSuporte(supSaida);
        }
        return listasup;
    }

    public AcessoSuporte buscar(AcessoSuporte acsup) throws SQLException, ClassNotFoundException {
        daoasup = new DaoAcessoSuporte();
        AcessoSuporte acsupSaida = daoasup.buscar(acsup);
        contsup = new ControleSuporte();
        Suporte supEntrada = new Suporte(acsupSaida.getId_func());
        Suporte supSaida = contsup.buscar(supEntrada);
        acsupSaida.setSuporte(supSaida);
        return acsupSaida;
    }

    public AcessoSuporte alterar(AcessoSuporte asup) throws SQLException, ClassNotFoundException {
        daoasup = new DaoAcessoSuporte();
        return daoasup.alterar(asup);
    }

    public AcessoSuporte excluir(AcessoSuporte asup) throws SQLException, ClassNotFoundException {
        daoasup = new DaoAcessoSuporte();
        return daoasup.excluir(asup);
    }

}
