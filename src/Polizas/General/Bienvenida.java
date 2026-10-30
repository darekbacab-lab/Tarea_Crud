package Polizas.General;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Bienvenida extends JFrame {

    protected JMenuBar mb;
    protected JMenu ma, mbD;
    protected JMenuItem home;
    protected JMenuItem mensaje, marcas, personas;

    protected CardLayout cl;
    protected JPanel pi, ps, pd, pc;

    public Bienvenida() {

        this.setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE
        );

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setBackground(Color.decode("#333333"));

        this.menu();

        // Panel izquierdo
        pi = new JPanel();
        pi.setBackground(Color.decode("#333333"));
        pi.add(new JLabel("Panel izquierdo"));
        pi.setPreferredSize(
                new Dimension(200, getHeight())
        );

        // Panel superior
        ps = new JPanel();
        ps.setBackground(new Color(20, 110, 55));

        JLabel titulo = new JLabel(
                "Sistema de Gestión ..."
        );

        titulo.setForeground(Color.WHITE);

        Font fuente = new Font(
                "Arial", Font.BOLD, 18
        );

        titulo.setFont(fuente);
        ps.add(titulo);

        // Panel central
        cl = new CardLayout();
        pc = new JPanel(cl);

        JLabel bienvenida = new JLabel(
                "Welcome to Java ...",
                SwingConstants.CENTER
        );

        bienvenida.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        JPanel panelHome = new JPanel(new BorderLayout());
        panelHome.add(bienvenida, BorderLayout.NORTH);

        pc.add(panelHome, "home");

        pc.add(new Mensaje(), "mensaje");

        // Panel derecho
        pd = new JPanel();
        pd.setBackground(Color.decode("#333333"));
        pd.add(new JLabel("Panel derecho"));
        pd.setPreferredSize(
                new Dimension(200, getHeight())
        );

        this.setLayout(new BorderLayout());

        this.add(pi, BorderLayout.WEST);
        this.add(pd, BorderLayout.EAST);
        this.add(ps, BorderLayout.NORTH);
        this.add(pc, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void menu() {

        this.mb = new JMenuBar();
        this.setJMenuBar(mb);

        this.ma = new JMenu("Archivo");

        home = new JMenuItem("Home");
        this.ma.add(home);

        this.mensaje = new JMenuItem("Mensaje");
        this.ma.add(mensaje);

        this.mb.add(ma);

        this.mbD = new JMenu("Base de Datos");

        marcas = new JMenuItem("Marcas");
        mbD.add(marcas);

        this.mb.add(mbD);
    }
}
