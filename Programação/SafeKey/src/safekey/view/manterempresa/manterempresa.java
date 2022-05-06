/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package safekey.view.manterempresa;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import safekey.SafeKey;

/**
 *
 * @author alexv
 */
public class manterempresa {
    public static void montarTela() throws SQLException, ClassNotFoundException {
        int ops = 0;
        try {
            ops = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                    + "CADASTRAR = 1\n"
                    + "LISTAR = 2\n"
                    + "BUSCAR = 3\n"
                    + "ALTERAR = 4\n"
                    + "EXCLUIR = 5"
                    + "", "MENU DE VEICULO", 3));
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
                JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU Empresa");
                montarTela();
            }
        }
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "INSERIR EMPRESA");
        String placa = JOptionPane.showInputDialog("ENTRE COM O CNPJ");
        String ano = JOptionPane.showInputDialog("ENTRE COM O ANO");
        String marca = JOptionPane.showInputDialog("ENTRE COM O MARCA");
        String modelo = JOptionPane.showInputDialog("ENTRE COM O MODELO");
        String cor = JOptionPane.showInputDialog("ENTRE COM O COR");
        if (!"".equals(placa)) {
            Veiculo vei = new Veiculo(placa, ano, marca, modelo, cor);
            ControleVeiculo contV = new ControleVeiculo();
            vei = contV.inserir(vei);
            JOptionPane.showMessageDialog(null, "VEICULO = " + vei.toString());
        } else {
            JOptionPane.showMessageDialog(null, "O CAMPO PLACA É NECESSARIO! ", "DADOS INCORRETOS", 2);
            montarTela();
        }

    }

    public static void listar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "LISTAR VEICULO");
        String placa = JOptionPane.showInputDialog("ENTRE COM PLACA");
        Veiculo vei = new Veiculo(placa);
        ControleVeiculo contV = new ControleVeiculo();
        List<Veiculo> listaV = contV.listar(vei);
        listaV.forEach((veiList) -> {
            JOptionPane.showMessageDialog(null, veiList.toString());
        });
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "BUSCAR VEICULO");
        String placa = JOptionPane.showInputDialog("ENTRE COM A PLACA");
        Veiculo vei = new Veiculo(placa);
        ControleVeiculo contV = new ControleVeiculo();
        vei = contV.buscar(vei);
        if (vei == null) {
            JOptionPane.showMessageDialog(null, "PLACA INEXISTENTE !", "TENTE OUTRA PLACA!", 1);

        } else {
            JOptionPane.showMessageDialog(null, "VEICULO = " + vei.toString());
        }

    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "ALTERAR VEICULO");
        String placa = JOptionPane.showInputDialog("ENTRE COM A PLACA");
        String ano = JOptionPane.showInputDialog("ENTRE COM O ANO");
        String marca = JOptionPane.showInputDialog("ENTRE COM O MARCA");
        String modelo = JOptionPane.showInputDialog("ENTRE COM O MODELO");
        String cor = JOptionPane.showInputDialog("ENTRE COM O COR");
        Veiculo vei = new Veiculo(placa, ano, marca, modelo, cor);
        ControleVeiculo contV = new ControleVeiculo();
        vei = contV.alterar(vei);
        JOptionPane.showMessageDialog(null, "VEICULO = " + vei.toString());

    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null, "EXCLUIR VEICULO");
        String placa = JOptionPane.showInputDialog("ENTRE COM A PLACA");
        Veiculo vei = new Veiculo(placa);
        ControleVeiculo contV = new ControleVeiculo();
        vei = contV.excluir(vei);
        JOptionPane.showMessageDialog(null, "VEICULO = " + vei.toString());

    }
}

    
}
