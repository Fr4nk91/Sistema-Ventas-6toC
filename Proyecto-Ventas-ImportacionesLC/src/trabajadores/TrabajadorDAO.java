/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajadores;

import conexion.ConexionBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class TrabajadorDAO {

    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(Trabajador trabajador) {
        int rsu = 0;
        String sql = "INSERT INTO trabajadores(nombre, apellido, direccion, telefono, email, cargo) VALUES(?,?,?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, trabajador.getNombre());
            ps.setString(2, trabajador.getApellido());
            ps.setString(3, trabajador.getDireccion());
            ps.setString(4, trabajador.getTelefono());
            ps.setString(5, trabajador.getEmail());
            ps.setString(6, trabajador.getCargo());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(Trabajador trabajador) {
        int rsu = 0;
        String sql = "UPDATE trabajadores SET nombre=?, apellido=?, direccion=?, telefono=?, email=?, cargo=? WHERE idtrabajador=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, trabajador.getNombre());
            ps.setString(2, trabajador.getApellido());
            ps.setString(3, trabajador.getDireccion());
            ps.setString(4, trabajador.getTelefono());
            ps.setString(5, trabajador.getEmail());
            ps.setString(6, trabajador.getCargo());
            ps.setInt(7, trabajador.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminar(int id) {
        int rsu = 0;
        String sql = "UPDATE trabajadores SET eliminado=1 WHERE idtrabajador=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) FormTrabajadores.tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = "SELECT * FROM trabajadores WHERE eliminado = 0 ORDER BY idtrabajador";
        } else {
            sql = "SELECT * FROM trabajadores WHERE (idtrabajador LIKE'" + busca + "%' OR "
                + "nombre LIKE'" + busca + "%' OR apellido LIKE'" + busca + "%' OR "
                + "direccion LIKE'" + busca + "%' OR telefono LIKE'" + busca + "%' OR "
                + "email LIKE'" + busca + "%' OR cargo LIKE'" + busca + "%') AND eliminado = 0 ORDER BY idtrabajador";
        }
        String datos[] = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idtrabajador");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("apellido");
                datos[3] = rs.getString("cargo");
                datos[4] = rs.getString("telefono");
                datos[5] = rs.getString("email");
                datos[6] = rs.getString("direccion");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(idtrabajador) FROM trabajadores";

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
