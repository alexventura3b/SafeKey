/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safekey.view.mantersuporte;

import safekey.SafeKey;
import safekey.controller.ControleSuporte;
import safekey.model.bean.AcessoSuporte;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterSuporte {

    public static void montarTela() throws SQLException, ClassNotFoundException {
        int ops = 0;
        try {
            ops = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                    + "INSERIR = 1"
                    + "\n LISTAR = 2"
                    + "\n BUSCAR = 3"
                    + "\n ALTERAR = 4"
                    + "\n EXCLUIR = 5"
                    + "", "MENU USUARIO", 3));
        } catch (NumberFormatException e) {
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
            default:
                JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU DE USUARIO");
                montarTela();
        }

    }

    public static boolean validaUsuario() throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        AcessoSuporte usuEntrada = new AcessoSuporte(login, senha);
        ControleSuporte contUsu = new ControleSuporte();
        AcessoSuporte usuSaida = contUsu.valida(usuEntrada);
        if (usuSaida != null) {
            retorno = true;
        }
        return retorno;
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "INSERIR USUARIO");
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        if ((!"".equalsIgnoreCase(login)) | (!"".equalsIgnoreCase(senha))) {
            AcessoSuporte usu = new AcessoSuporte(0, login, senha, status, tipo);
            ControleSuporte contU = new ControleSuporte();
            usu = contU.inserir(usu);
            JOptionPane.showMessageDialog(null, "USUARIO = " + usu.toString());
        } else {
            JOptionPane.showMessageDialog(null, "O LOGIN E SENHA SÃO OBRIGATÓRIOS!", "RETORNANDO", 2);
            montarTela();
        }
    }

    public static void listar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "LISTAR USUARIO");
        String login = JOptionPane.showInputDialog("ENTRE COM O LOGIN");
        AcessoSuporte usu = new AcessoSuporte(login);
        ControleSuporte contU = new ControleSuporte();
        List<AcessoSuporte> listaU = contU.listar(usu);
        listaU.forEach((usuL) -> {
            JOptionPane.showMessageDialog(null, usuL.toString());
        });
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "BUSCAR USUARIO");
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
        AcessoSuporte usu = new AcessoSuporte(idUsu);
        ControleSuporte contU = new ControleSuporte();
        usu = contU.buscar(usu);
        JOptionPane.showMessageDialog(null, "USUARIO = " + usu.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "ALTERAR USUARIO");
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        AcessoSuporte usu = new AcessoSuporte(idUsu, login, senha, status, tipo);
        ControleSuporte contU = new ControleSuporte();
        usu = contU.alterar(usu);
        JOptionPane.showMessageDialog(null, "USUARIO = " + usu.toString());
    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "EXCLUIR USUARIO");
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
        AcessoSuporte usu = new AcessoSuporte(idUsu);
        ControleSuporte contU = new ControleSuporte();
        usu = contU.excluir(usu);
        JOptionPane.showMessageDialog(null, "USUARIO = " + usu.toString());

    }
}
