/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
public class VentaDAO {

    static ConexionBD cc = new ConexionBD();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(Venta v) {
        int rsu = 0;
        String sql = Venta.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, v.getIdventa());
            ps.setInt(2, v.getIdcliente());
            ps.setInt(3, v.getIdusuario());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getTotal());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(Venta v) {
        int rsu = 0;
        String sql = Venta.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, v.getIdcliente());
            ps.setInt(2, v.getIdusuario());
            ps.setString(3, v.getFecha());
            ps.setDouble(4, v.getTotal());
            ps.setInt(5, v.getIdventa());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminar(int id) {
        int rsu = 0;
        String sql = Venta.ELIMINAR;
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

    public static int eliminarTodo() {
        int rsu = 0;
        String sql = Venta.ELIMINAR_TODO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
            rsu++;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) ventas.FormVentasProductos.tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Venta.LISTAR;
        } else {
            sql = "SELECT * FROM ventas WHERE (idventa LIKE'" + busca + "%' OR "
                + "idcliente LIKE'" + busca + "%' OR idusuario LIKE'" + busca + "%' OR "
                + "fecha LIKE'" + busca + "%' OR total LIKE'" + busca + "%') ORDER BY fecha";
        }
        String datos[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idventa");
                datos[1] = rs.getString("idcliente");
                datos[2] = rs.getString("idusuario");
                datos[3] = rs.getString("fecha");
                datos[4] = rs.getString("total");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listarVentas(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) ventas.FormCorteCaja.tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Venta.LISTAR1;
        } else {
            sql = "SELECT * FROM ventas, producto WHERE (idventa LIKE'" + busca + "%' OR "
                + "nombre LIKE'" + busca + "%' OR descripcion LIKE'" + busca + "%' OR "
                + "total LIKE'" + busca + "%' OR fecha LIKE'" + busca + "%') AND id_producto = idproducto";
        }
        String datos[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idventa");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("descripcion");
                datos[3] = rs.getString("total");
                datos[4] = rs.getString("fecha");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

