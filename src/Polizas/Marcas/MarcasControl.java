
package Polizas.Marcas;

import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JOptionPane;

public class MarcasControl {

    private MarcasVista mv;
    private MarcasModelo mm;
    private List<Marca> lista;

    public MarcasControl(MarcasVista marcasVista) {

        this.mv = marcasVista;
        this.mm = new MarcasModelo();

        marcasEventos();
    }

    public void marcasEventos() {

        mv.btn1.addActionListener(e -> {

            lista = mm.read();
            mv.actualizarVista(lista);
        });

        mv.btn_a.addActionListener(e -> {

            String nombre = mv.txt1.getText().trim();

            if (nombre.isEmpty()) {

                JOptionPane.showMessageDialog(
                    null, "Ingresa el nombre de una marca"
                );

                return;
            }

            lista = mm.read();

            for (Marca m : lista) {

                if (m.getNombre().trim().equalsIgnoreCase(nombre)) {

                    JOptionPane.showMessageDialog(
                        null, "Esta marca ya está registrada"
                    );

                    return;
                }
            }

            Marca marca = new Marca(0, nombre);

            int resultado = mm.create(marca);

            if (resultado > 0) {

                JOptionPane.showMessageDialog(
                    null, "Marca agregada correctamente"
                );

                mv.txt1.setText("");
                mv.actualizarVista(mm.read());

            } else {

                JOptionPane.showMessageDialog(
                    null, "No se pudo agregar la marca"
                );
            }
        });
        mv.tabla.addMouseListener(
            new MouseAdapter() {

                @Override
                public void mouseClicked(
                    java.awt.event.MouseEvent e
                ) {

                    int fila = mv.tabla.getSelectedRow();

                    if (fila >= 0) {

                        System.out.println(
                            "Registro: "
                            + mv.marcasModelo.getValueAt(fila, 1)
                        );

                        mv.txt1.setText(
                            String.valueOf(
                                mv.marcasModelo.getValueAt(fila, 1)
                            )
                        );
                    }
                }
            }
        );

        mv.tabla.getSelectionModel()
            .addListSelectionListener(e -> {

                if (!e.getValueIsAdjusting()) {

                    int fila = mv.tabla.getSelectedRow();

                    if (fila >= 0) {

                        System.out.println(
                            "Registro: " + fila
                            + " - Valor: "
                            + mv.tabla.getValueAt(fila, 1)
                        );
                    }
                }
            });
 
        mv.cmbMarcas.addActionListener(e -> {

            Marca marca = (Marca)
                mv.cmbMarcas.getSelectedItem();
        });

        mv.btn_u.addActionListener(e -> {

            int fila = mv.tabla.getSelectedRow();

            if (fila >= 0) {

                String nombre = mv.txt1.getText().trim();

                if (nombre.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        null, "Ingresa el nombre de la marca"
                    );

                    return;
                }

                Marca marca = mv.marcasModelo.getMarca(fila);

                lista = mm.read();

                for (Marca m : lista) {

                    if (m.getId() != marca.getId()
                        && m.getNombre().trim().equalsIgnoreCase(nombre)) {

                        JOptionPane.showMessageDialog(
                            null, "Ya existe otra marca con ese nombre"
                        );

                        return;
                    }
                }

                marca.setNombre(nombre);

                int resultado = mm.update(marca);

                if (resultado > 0) {

                    JOptionPane.showMessageDialog(
                        null, "Marca actualizada correctamente"
                    );

                    mv.txt1.setText("");
                    mv.actualizarVista(mm.read());

                } else {

                    JOptionPane.showMessageDialog(
                        null, "No se pudo actualizar la marca"
                    );
                }

            } else {

                JOptionPane.showMessageDialog(
                    null, "Selecciona una marca de la tabla"
                );
            }
        });

       
        mv.btn_d.addActionListener(e -> {

            int fila = mv.tabla.getSelectedRow();

            if (fila >= 0) {

                Marca marca = mv.marcasModelo.getMarca(fila);

                int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Estás seguro de eliminar esta marca?"
                );

                if (respuesta == JOptionPane.YES_OPTION) {

                    int resultado = mm.delete(marca);

                    if (resultado > 0) {

                        JOptionPane.showMessageDialog(
                            null, "Marca eliminada correctamente"
                        );

                        mv.txt1.setText("");
                        mv.actualizarVista(mm.read());

                    } else {

                        JOptionPane.showMessageDialog(
                            null, "No se pudo eliminar la marca"
                        );
                    }
                }

            } else {

                JOptionPane.showMessageDialog(
                    null, "Selecciona una marca de la tabla"
                );
            }
        });

    }

}
