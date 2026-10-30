package Polizas.Marcas;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MarcasVista extends JPanel {

    protected JButton btn1, btn_a, btn_u, btn_d;
    protected JTextField txt1;
    protected JLabel lbl1, lbl2;

    protected JTable tabla;
    protected MarcasTM marcasModelo;

    protected String[] columnas = {"id", "nombre"};

    protected JComboBox<Marca> cmbMarcas;

    public MarcasVista() {

        setLayout(null);

        lbl1 = new JLabel("Welcome to Marcas Admin.");
        lbl1.setBounds(350, 5, 200, 30);

        lbl2 = new JLabel("Ingresa una marca:");
        lbl2.setBounds(120, 40, 150, 30);

        txt1 = new JTextField("Marca 1");
        txt1.setBounds(235, 40, 250, 30);

        cmbMarcas = new JComboBox<>();
        cmbMarcas.setBounds(550, 40, 250, 30);
        add(cmbMarcas);

        btn1 = new JButton("Consultar");
        btn1.setBounds(150, 90, 100, 30);

        btn_a = new JButton("Agregar");
        btn_a.setBounds(250, 90, 100, 30);
        
        btn_u = new JButton("Actualizar");
        btn_u.setBounds(350, 90, 100,30);
        
        btn_d = new JButton("Eliminar");
        btn_d.setBounds(450,90,100,30);
        
        

        marcasModelo = new MarcasTM();

        tabla = new JTable(marcasModelo);

        marcasModelo.fireTableDataChanged();

        JScrollPane sc = new JScrollPane(tabla);
        sc.setBounds(130, 150, 800, 500);

        this.add(sc);
        this.add(lbl1);
        this.add(lbl2);
        this.add(txt1);
        this.add(btn1);
        this.add(btn_a);
        this.add(btn_u);
        this.add(btn_d);
    }

    public void actualizarVista(List<Marca> lista) {

        marcasModelo.vaciarLista();

        for (Marca marca : lista) {
            marcasModelo.addMarca(marca);
        }

        cmbMarcas.removeAllItems();

        for (Marca marca : lista) {
            cmbMarcas.addItem(marca);
        }
    }
}