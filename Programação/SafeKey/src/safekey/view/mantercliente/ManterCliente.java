/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.view.mantercliente;

import safekey.SafeKey;
import safekey.controller.ControleCliente;
import safekey.model.bean.Cliente;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alexv
 */
public class ManterCliente {

    public static void montarTela() throws SQLException, ClassNotFoundException {
        int ops = 0;
        try {
            ops = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                    + "CADASTRAR = 1\n"
                    + "LISTAR = 2\n"
                    + "BUSCAR = 3\n"
                    + "ALTERAR = 4\n"
                    + "EXCLUIR = 5"
                    + "", "MENU CLIENTE", 3));
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
                JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU DE CLIENTE");
                montarTela();
            }
        }

    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "INSERIR CLIENTE");

        String cpf = JOptionPane.showInputDialog("ENTRE COM O CPF");
        String nome = JOptionPane.showInputDialog("ENTRE COM O NOME DO CLIENTE");
        String telefone = JOptionPane.showInputDialog("DIGITE O TELEFONE");
        //Contruir o Cadastro de contato
        int idcontato=0;
        String data = String.valueOf(Calendar.DATE);
        if (!"".equals(cpf)) {
            Cliente clie = new Cliente(0,nome,cpf,idcontato,data);
            ControleCliente contC = new ControleCliente();
            clie = contC.inserir(clie);
            JOptionPane.showMessageDialog(null, "CLIENTE = " + clie.toString());
        } else {
            JOptionPane.showMessageDialog(null, "O CPF É OBRIGATÓRIO!", "RETORNANDO", 2);
            montarTela();
        }

    }

    public static void listar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "LISTAR CLIENTE");
        String cpf = JOptionPane.showInputDialog("ENTRE COM O CPF DO CLIENTE");
        Cliente clie = new Cliente(cpf);
        ControleCliente contC = new ControleCliente();
        List<Cliente> listaC = contC.listar(clie);
        listaC.forEach((clieList) -> {
            JOptionPane.showMessageDialog(null, clieList.toString());
        });
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "BUSCAR CLIENTE");
        String cpf = JOptionPane.showInputDialog("ENTRE COM O CPF");
        Cliente clie = new Cliente(cpf);
        ControleCliente contC = new ControleCliente();
        clie = contC.buscar(clie);
        if (clie == null) {
            JOptionPane.showMessageDialog(null, "CLIENTE INEXISTENTE!", "TENTE OUTRO CPF!", 1);
        } else {
            JOptionPane.showMessageDialog(null, "CLIENTE = " + clie.toString());
        }

    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "ALTERAR CLIENTE");
        String cpf = JOptionPane.showInputDialog("ENTRE COM O CPF");
        String nome = JOptionPane.showInputDialog("DIGITE O NOME DO CLIENTE");
        String data= String.valueOf(Calendar.DATE);
        Cliente clie = new Cliente(cpf,nome,data);
        ControleCliente contC = new ControleCliente();
        clie = contC.alterar(clie);
        JOptionPane.showMessageDialog(null, "CLIENTE = " + clie.toString());

    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "EXCLUIR CLIENTE");
        String cpf = JOptionPane.showInputDialog("ENTRE COM O CPF DO CLIENTE");
        Cliente clie = new Cliente(cpf);
        ControleCliente contC = new ControleCliente();
        clie = contC.excluir(clie);
        JOptionPane.showMessageDialog(null, "CLIENTE = " + clie.toString());
    }
}
