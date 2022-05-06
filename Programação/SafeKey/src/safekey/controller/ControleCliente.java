/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.controller;

import safekey.model.bean.Cliente;
import safekey.model.dao.DaoCliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alexv
 */
public class ControleCliente {

    static DaoCliente daocli;

//    public ControleCliente() throws SQLException, ClassNotFoundException{
//        daocli=new DaoCliente();
//    }
    public Cliente inserir(Cliente cli) throws SQLException, ClassNotFoundException {
        daocli = new DaoCliente();
        return daocli.inserir(cli);
    }

    public List<Cliente> listar(Cliente cli) throws SQLException, ClassNotFoundException {
        daocli = new DaoCliente();
        return daocli.listar(cli);
    }

    public Cliente buscar(Cliente cli) throws SQLException, ClassNotFoundException {
        daocli = new DaoCliente();
        return daocli.buscar(cli);
    }

    public Cliente alterar(Cliente cli) throws SQLException, ClassNotFoundException {
        daocli = new DaoCliente();
        return daocli.alterar(cli);
    }

    public Cliente excluir(Cliente cli) throws SQLException, ClassNotFoundException {
        daocli = new DaoCliente();
        return daocli.excluir(cli);
    }

}
