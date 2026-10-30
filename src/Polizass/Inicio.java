package Polizass;

import Polizas.General.Controlador;
import Polizas.General.Bienvenida;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.FlatDarkLaf;

public class Inicio {

    private Controlador controlador;
    private Bienvenida vista;

    public Inicio() {
        vista = new Bienvenida();
        controlador = new Controlador(vista);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            FlatDarkLaf.setup();
            new Inicio();
        });
    }
}