/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.view.manterclientelocker;

import safekey.SafeKey;
import safekey.controller.ControleClienteLocker;
import safekey.model.bean.ClienteLocker;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author alexv
 */
public class ManterClienteLocker {

    public static void montarTela() throws SQLException, ClassNotFoundException {
        int ops = 0;
        try {
            ops = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                    + "CADASTRAR = 1\n"
                    + "LISTAR = 2\n"
                    + "BUSCAR = 3\n"
                    + "ALTERAR = 4\n"
                    + "EXCLUIR = 5"
                    + "", "MENU CLIENTE - VEICULO", 3));
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU PRINCIPAL");
            String[] args = null;
            SafeKey.main(args);
        }

        switch (ops) {
            case 1:
                inserir();
                break;
            case 2:
                listar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                alterar();
                break;
            case 5:
                excluir();
                break;
            default: {
                JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU CLIENTE - VEICULO");
                montarTela();
            }
        }

    }

    public static void listar() throws SQLException, ClassNotFoundException {

        JOptionPane.showMessageDialog(null, "LISTAR CONTRATOS DE LOCKERS");
        int num_contrato = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O NUMERO DE CONTRATO"));

        ClienteLocker clilocker = new ClienteLocker(num_contrato);
        ControleClienteLocker Contclilok = new ControleClienteLocker();
        List<ClienteLocker> listaCL = Contclilok.listar(clilocker);
        listaCL.forEach((ClienteLocker listaCL2) -> {
            JOptionPane.showMessageDialog(null, listaCL2.toString());
            JOptionPane.showMessageDialog(null, "LOCKER = " + listaCL2.getNum_contrato());
            JOptionPane.showMessageDialog(null, "VEÍCULO = " + listaCL2.getVeiculo().getPlaca());
        });
    }
//Parei aqui!!!
    public static void inserir() throws SQLException, ClassNotFoundException {

        int id_cliente = 0;
        //teste ramdom para numero contrato
        double x1=1,x2=1;
        double f = Math.random()/Math.nextDown(10000);
        int aleatorio = (int) (x1*(100 - f) + x2*f);
         //modificar        
        JOptionPane.showMessageDialog(null, "INSERIR CONTRATO LOCKER");
        id_cliente = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O CPF DO CLIENTE"));
        String placa = JOptionPane.showInputDialog("ENTRE COM A PLACA DO VEICULO");
        int num_contrato=aleatorio;
        
        if (!"".equals(placa)) {
            ClienteLocker clilocker = new ClienteLocker(0,num_contrato, id_cliente, placa, id_compart, data, hora, obs, id_tarifa, pago, id_pagamento);
            ControleClienteLocker contclilock = new ControleClienteLocker();
            clilocker = contclilock.inserir(clilocker);
            JOptionPane.showMessageDialog(null, "CONTRATO = " + clilocker.toString());
        } else {
            JOptionPane.showMessageDialog(null, "CPF DO CLIENTE OU PLACA SÃO OBRIGATÓRIOS! ", "DADOS INCORRETOS", 2);
            montarTela();
        }
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "BUSCAR CLIENTE VEICULO");
        try {
            int ticket = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O TICKET"));

            ClienteLocker cliveic = new ClienteLocker(ticket);
            ControleClienteLocker contcv = new ControleClienteLocker();
            cliveic = contcv.buscar(cliveic);
            JOptionPane.showMessageDialog(null, "CLIENTE_VEICULO = " + cliveic.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "ALTERAR CLIENTE_VEICULO");
        int ticket = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O TICKET"));
        int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID DO CLIENTE"));
        String placa = JOptionPane.showInputDialog("ENTRE COM A PLACA");
        String ini = JOptionPane.showInputDialog("ENTRE COMO O INICIO DA ESTADIA");
        String fim = JOptionPane.showInputDialog("ENTRE COMO O FIM DA ESTADIA");
        ClienteLocker cliveic = new ClienteLocker(ticket, id_cliente, placa, ini, fim);
        ControleClienteLocker contcv = new ControleClienteLocker();
        cliveic = contcv.alterar(cliveic);
        JOptionPane.showMessageDialog(null, "CLIENTE_VEICULO = " + cliveic.toString());
    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "EXCLUIR CLIENTE_VEICULO");
        int id = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O TICKET"));
        ClienteLocker clieveic = new ClienteLocker(id);
        ControleClienteLocker contcv = new ControleClienteLocker();
        clieveic = contcv.excluir(clieveic);
        JOptionPane.showMessageDialog(null, "CLIENTE_VEICULO = " + clieveic.toString());
    }
}
