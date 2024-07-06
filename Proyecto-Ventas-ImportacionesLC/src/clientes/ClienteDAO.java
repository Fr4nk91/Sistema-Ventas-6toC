/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;


import conexion.ConexionBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ClienteDAO {

    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(Cliente uc) {
        int rsu = 0;
        String sql = Cliente.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNombre());
            ps.setString(2, uc.getApellido());
            ps.setString(3, uc.getDireccion());
            ps.setString(4, uc.getTelefono());
            ps.setString(5, uc.getEmail());
            ps.setString(6, uc.getDocumento());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(Cliente uc) {
        int rsu = 0;
        String sql = Cliente.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNombre());
            ps.setString(2, uc.getApellido());
            ps.setString(3, uc.getDireccion());
            ps.setString(4, uc.getTelefono());
            ps.setString(5, uc.getEmail());
            ps.setString(6, uc.getDocumento());
            ps.setInt(7, uc.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminar(int id) {
        int rsu = 0;
        String sql = Cliente.ELIMINAR;

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
        String sql = Cliente.ELIMINAR_TODO;

        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) clientes.FormClientes.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Cliente.LISTAR;
        } else {
            sql = "SELECT idcliente, nombre, apellido, documento, telefono, email, direccion  FROM clientes WHERE (idcliente LIKE'" + busca + "%' OR "
                    + "nombre LIKE'" + busca + "%' OR apellido LIKE'" + busca + "%' OR "
                    + "direccion LIKE'" + busca + "%' OR telefono LIKE'" + busca + "%' OR "
                    + "email LIKE'" + busca + "%') AND eliminado = 0 "
                    + "ORDER BY idcliente";
        }
        String datos[] = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idcliente");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("apellido");
                datos[3] = rs.getString("documento");
                datos[4] = rs.getString("telefono");
                datos[5] = rs.getString("email");
                datos[6] = rs.getString("direccion");
             
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public static boolean esDocumentoUnico(String documento, int idCliente) {
    boolean esUnico = true;
    String sql = "SELECT COUNT(*) FROM clientes WHERE documento = ? AND idcliente != ? AND eliminado = 0";
    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, documento);
        ps.setInt(2, idCliente);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    esUnico = false;
                }
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return esUnico;
}

    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(idcliente) FROM clientes";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public static void iniciarTransaccion() {
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void finalizarTransaccion() {
        try {
            cn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cancelarTransaccion() {
        try {
            cn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

