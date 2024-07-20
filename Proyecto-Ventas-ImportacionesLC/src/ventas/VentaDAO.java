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

     // Método para registrar una venta
    public static int registrar(Venta v, Connection cn) {
        int generatedId = 0;
        String sql = Venta.REGISTRAR;
        try (PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, v.getIdcliente());
            ps.setInt(2, v.getIdusuario());
            ps.setString(3, v.getFecha());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return generatedId;
    }
    public static int actualizar(Venta v) {
        int rsu = 0;
        String sql = Venta.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, v.getIdcliente());
            ps.setInt(2, v.getIdusuario());
            ps.setString(3, v.getFecha());
            ps.setInt(4, v.getIdventa());
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
public static void listarVentas(String busca) {
    DefaultTableModel modelo = (DefaultTableModel) ventas.FormVentasBuscar.tabla.getModel();
    while (modelo.getRowCount() > 0) {
        modelo.removeRow(0);
    }

    String sql;
    if (busca.equals("")) {
        sql = Venta.LISTAR;
    } else {
        sql = "SELECT A.idventa, A.idcliente, CONCAT(B.nombre, ' ', B.apellido) AS cliente, "
            + "A.idusuario, CONCAT(D.nombre, ' ', D.apellido) AS trabajador, A.fecha, "
            + "SUM(E.cantidad * E.precio_unitario) AS total "
            + "FROM ventas A INNER JOIN clientes B ON A.idcliente = B.idcliente "
            + "INNER JOIN usuarios C ON A.idusuario = C.idusuario "
            + "INNER JOIN trabajadores D ON C.idtrabajador = D.idtrabajador "
            + "INNER JOIN detalle_ventas E ON A.idventa = E.idventa "
            + "WHERE A.eliminado = 0 AND E.eliminado = 0 "
            + "GROUP BY A.idventa, A.idcliente, cliente, A.idusuario, trabajador, A.fecha "
            + "HAVING A.idventa LIKE ? OR "
            + "A.idcliente LIKE ? OR "
            + "A.idusuario LIKE ? OR "
            + "cliente LIKE ? OR "
            + "trabajador LIKE ? OR "
            + "A.fecha LIKE ? OR "
            + "total LIKE ? "
            + "ORDER BY A.fecha";
    }

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        if (!busca.equals("")) {
            String buscaPattern = busca + "%";
            ps.setString(1, buscaPattern);
            ps.setString(2, buscaPattern);
            ps.setString(3, buscaPattern);
            ps.setString(4, buscaPattern);
            ps.setString(5, buscaPattern);
            ps.setString(6, buscaPattern);
            ps.setString(7, buscaPattern);
        }

        try (ResultSet rs = ps.executeQuery()) {
            String[] datos = new String[7];
            while (rs.next()) {
                datos[0] = rs.getString("idventa");
                datos[1] = rs.getString("idcliente");
                datos[2] = rs.getString("cliente");
                datos[3] = rs.getString("idusuario");
                datos[4] = rs.getString("trabajador");
                datos[5] = rs.getString("fecha");
                datos[6] = rs.getString("total");
                modelo.addRow(datos);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}




    public static String[] listarVenta(String codigoVenta) {
        String sql = "";
        sql = "SELECT A.idventa, A.idcliente, CONCAT(B.nombre, ' ', B.apellido) AS cliente, "
            + "A.idusuario, C.usuario, CONCAT(D.nombre, ' ', D.apellido) AS trabajador, A.fecha "
            + "FROM ventas A INNER JOIN clientes B ON A.idcliente = B.idcliente "
            + "INNER JOIN usuarios C ON A.idusuario = C.idusuario "
            + "INNER JOIN trabajadores D ON C.idtrabajador = D.idtrabajador "
            + "WHERE A.eliminado = 0 AND A.idventa = " + codigoVenta + " "
            + "ORDER BY A.fecha";
        String datos[] = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idventa");
                datos[1] = rs.getString("idcliente");
                datos[2] = rs.getString("cliente");
                datos[3] = rs.getString("idusuario");
                datos[4] = rs.getString("usuario");
                datos[5] = rs.getString("trabajador");
                datos[6] = rs.getString("fecha");
            }
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return datos;
        }
    }
    
     // Métodos iniciarTransaccion, finalizarTransaccion y cancelarTransaccion
    public static void iniciarTransaccion(Connection cn) {
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void finalizarTransaccion(Connection cn) {
        try {
            cn.commit();
        } catch (SQLException ex) {
            cancelarTransaccion(cn);
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cancelarTransaccion(Connection cn) {
        try {
            cn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

