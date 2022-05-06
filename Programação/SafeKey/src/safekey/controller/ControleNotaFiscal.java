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

/**
 *
 * @author alexv
 */
public class ControleNotaFiscal {

    static DaoClienteLocker daocv;
    static ControleVeiculo cvei;
    static ControleCliente cclie;

    public ClienteLocker inserir(ClienteLocker cv) throws SQLException, ClassNotFoundException {
        daocv = new DaoClienteLocker();
        return daocv.inserir(cv);
    }

    public List<ClienteLocker> listar(ClienteLocker cv) throws SQLException, ClassNotFoundException {
        daocv = new DaoClienteLocker();
        List<ClienteLocker> listaCV = daocv.listar(cv);
        for (ClienteLocker listaCV2 : listaCV) {
            cclie = new ControleCliente();
            cvei = new ControleVeiculo();
            Cliente clieEntrada = new Cliente(listaCV2.getId_cliente());
            Veiculo veicEntrada = new Veiculo(listaCV2.getId_veiculo());
            Cliente clieSaida = cclie.buscar(clieEntrada);
            Veiculo veicSaida = cvei.buscar(veicEntrada);
            listaCV2.setCliente(clieSaida);
            listaCV2.setVeiculo(veicSaida);
        }
        return listaCV;
    }

    public ClienteLocker buscar(ClienteLocker cv) throws SQLException, ClassNotFoundException {
        daocv = new DaoClienteLocker();
        ClienteLocker cvSaida = daocv.buscar(cv);
        cclie = new ControleCliente();
        cvei = new ControleVeiculo();
        Cliente clieEntrada = new Cliente(cvSaida.getId_cliente());
        Veiculo veicEntrada = new Veiculo(cvSaida.getId_veiculo());
        Cliente clieSaida = cclie.buscar(clieEntrada);
        Veiculo veicSaida = cvei.buscar(veicEntrada);
        cvSaida.setCliente(clieSaida);
        cvSaida.setVeiculo(veicSaida);
        return cvSaida;
        //return daocv.buscar(cv);
    }

    public ClienteLocker alterar(ClienteLocker cv) throws SQLException, ClassNotFoundException {
        daocv = new DaoClienteLocker();
        return daocv.alterar(cv);
    }

    public ClienteLocker excluir(ClienteLocker cv) throws SQLException, ClassNotFoundException {
        daocv = new DaoClienteLocker();
        return daocv.excluir(cv);
    }

}
