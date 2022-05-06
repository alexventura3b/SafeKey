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

        JOptionPane.showMessageDialog(null, "LISTAR CLIENTE VEICULO");
        String placa = JOptionPane.showInputDialog("ENTRE COM A PLACA");

        ClienteLocker clivei = new ClienteLocker(placa);
        ControleClienteLocker contCV = new ControleClienteLocker();
        List<ClienteLocker> listaCV = contCV.listar(clivei);
        listaCV.forEach((ClienteLocker cliveiList) -> {
            JOptionPane.showMessageDialog(null, cliveiList.toString());
            JOptionPane.showMessageDialog(null, "CLIENTE = " + cliveiList.getCliente().getNome());
            JOptionPane.showMessageDialog(null, "PLACA = " + cliveiList.getVeiculo().getPlaca());
        });
    }

    public static void inserir() throws SQLException, ClassNotFoundException {

        int id_cliente = 0;
        JOptionPane.showMessageDialog(null, "INSERIR CLIENTE VEICULO");
        try {
            id_cliente = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID DO CLIENTE"));
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "ID INVÁLIDO");
            montarTela();
        }
        String placa = JOptionPane.showInputDialog("ENTRE COM A PLACA DO VEICULO");
        String entrada = JOptionPane.showInputDialog("ENTRADA");
        String saida = JOptionPane.showInputDialog("SAIDA");
        if (!"".equals(placa)) {
            ClienteLocker clivei = new ClienteLocker(0, id_cliente, placa, entrada, saida);
            ControleClienteLocker contcv = new ControleClienteLocker();
            clivei = contcv.inserir(clivei);
            JOptionPane.showMessageDialog(null, "CLIENTE_VEICULO = " + clivei.toString());
        } else {
            JOptionPane.showMessageDialog(null, "ID DO CLIENTE OU PLACA SÃO OBRIGATÓRIOS! ", "DADOS INCORRETOS", 2);
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
