/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.controller;

import safekey.model.bean.Cliente;
import java.sql.SQLException;
import java.util.List;
import safekey.model.bean.AcessoCliente;
import safekey.model.dao.DaoAcessoCliente;

/**
 *
 * @author alexv
 */
public class ControleAcessoCliente {
    
    static DaoAcessoCliente daoacli;
    static ControleCliente contcli;

    public AcessoCliente inserir(AcessoCliente acli) throws SQLException, ClassNotFoundException {
        daoacli = new DaoAcessoCliente();
        return daoacli.inserir(acli);
    }

    public List<AcessoCliente> listar(AcessoCliente acli) throws SQLException, ClassNotFoundException {
        daoacli = new DaoAcessoCliente();
        List<AcessoCliente> listaacli = daoacli.listar(acli);
        for (AcessoCliente listacli2 : listaacli) {
            contcli = new ControleCliente();
            Cliente cliEntrada = new Cliente(listacli2.getId_cliente());
            Cliente clieSaida = contcli.buscar(cliEntrada);
            listacli2.setCliente(clieSaida);
           }
        return listaacli;
    }

    public AcessoCliente buscar(AcessoCliente acli) throws SQLException, ClassNotFoundException {
        daoacli = new DaoAcessoCliente();
        AcessoCliente acliSaida = daoacli.buscar(acli);
        contcli = new ControleCliente();
        Cliente clieEntrada = new Cliente(acliSaida.getId_cliente());
        Cliente clieSaida = contcli.buscar(clieEntrada);
        acliSaida.setCliente(clieSaida);
        return acliSaida;
        //return daocv.buscar(cv);
    }

    public AcessoCliente alterar(AcessoCliente acli) throws SQLException, ClassNotFoundException {
        daoacli = new DaoAcessoCliente();
        return daoacli.alterar(acli);
    }

    public AcessoCliente excluir(AcessoCliente acli) throws SQLException, ClassNotFoundException {
        daoacli = new DaoAcessoCliente();
        return daoacli.excluir(acli);
    }

}
