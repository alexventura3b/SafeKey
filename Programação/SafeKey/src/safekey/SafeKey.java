/*
main SafeKey
 */
package safekey;

import safekey.view.mantercliente.ManterCliente;
import safekey.view.manterclientelocker.ManterClienteLocker;
import safekey.view.mantersuporte.ManterSuporte;
import safekey.view.manterveiculo.ManterVeiculo;
import static java.lang.System.exit;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alexv
 */
public class SafeKey {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int ops = 0;
        try {
            ops = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                    + "CLIENTE : 1\n"
                    + "VEICULO : 2\n"
                    + "CLIENTE VEICULO : 3\n"
                    + "USUARIO : 4"
                    + "", "MENU PRINCIPAL", 3));
        } catch (NumberFormatException n) {
            exit(0);
        }
        switch (ops) {
            case 1:
                ManterCliente.montarTela();
                break;
            case 2:
                ManterVeiculo.montarTela();
                break;
            case 3:
                ManterClienteLocker.montarTela();
                break;
            case 4:
                ManterSuporte.montarTela();
                break;
            default: {
                JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU PRINCIPAL");
                SafeKey.main(args);
            }
        }
        SafeKey.main(args);
    }
}
