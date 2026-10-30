package Polizas.Marcas;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import Polizas.General.Conexion;
import Polizas.General.DAO;
import javax.swing.JOptionPane;

public class MarcasModelo extends Conexion
        implements DAO {

    public MarcasModelo() {
        super();
    }

    @Override
    public List read() {

        List<Marca> lista = new ArrayList<>();

        try {

            this.conectar();

            ps = cnx.prepareStatement(
                    "SELECT * FROM marcas"
            );

            rs = ps.executeQuery();
            lista.clear();

            while (rs.next()) {

                lista.add(
                        new Marca(
                                rs.getInt("id"),
                                rs.getString("nombre")
                        )
                );
            }

        } catch (SQLException ex) {

            System.out.println(
                    "Error: " + ex.getMessage()
            );

        } finally {

            close();
        }

        return lista;
    }

   @Override
public int create(Object obj) {
    Marca marca = (Marca) obj;

    try {
        this.conectar();

        ps = cnx.prepareStatement(
            "INSERT INTO marcas (nombre) VALUES (?)"
        );

        ps.setString(1, marca.getNombre());

        int resultado = ps.executeUpdate();

        return resultado;

    } catch (java.sql.SQLException e) {
        JOptionPane.showMessageDialog(
            null, "Error al agregar: " + e.getMessage()
        );
        return 0;

    } finally {
        this.close();
    }
}
    @Override
public int delete(Object obj) {

    Marca marca = (Marca) obj;

    try {
        this.conectar();

        ps = cnx.prepareStatement(
            "DELETE FROM marcas WHERE id = ?"
        );

        ps.setInt(1, marca.getId());

        return ps.executeUpdate();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(
            null, "Error al eliminar: " + ex.getMessage()
        );

        return 0;

    } finally {
        this.close();
    }
}
        
    

    @Override
public int update(Object obj) {

    Marca marca = (Marca) obj;

    try {
        this.conectar();

        ps = cnx.prepareStatement(
            "UPDATE marcas SET nombre = ? WHERE id = ?"
        );

        ps.setString(1, marca.getNombre());
        ps.setInt(2, marca.getId());

        return ps.executeUpdate();

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(
            null, "Error al actualizar: " + ex.getMessage()
        );

        return 0;

    } finally {
        this.close();
    }
}}
