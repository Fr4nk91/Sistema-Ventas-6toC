/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class ProductoDAO {

    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(Producto uc) {
        int rsu = 0;
        String sql = Producto.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNombre());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getTipo());
            ps.setDouble(4, uc.getPrecio());
            ps.setString(5, uc.getStock());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(Producto uc) {
        int rsu = 0;
        String sql = Producto.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNombre());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getTipo());
            ps.setDouble(4, uc.getPrecio());
            ps.setString(5, uc.getStock());
            ps.setInt(6, uc.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static int actualizarStock(Producto uc, Connection cn) {
        int rsu = 0;
        String sql = Producto.ACTUALIZAR_STOCK;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getStock());
            ps.setInt(2, uc.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminar(int id) {
        int rsu = 0;
        String sql = Producto.ELIMINAR;

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
        String sql = Producto.ELIMINAR_TODO;

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
        listar(busca, true);
    }
    public static void listar(String busca, boolean defaultProducto) {
        DefaultTableModel modelo;
        if (defaultProducto) {
            modelo = (DefaultTableModel) productos.FormProductos.tabla.getModel();
        }else{
            modelo = (DefaultTableModel) ventas.FormVentasProductos.tabla.getModel();
        }
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Producto.LISTAR;
        } else {
            sql = "SELECT idproducto, nombre, descripcion, tipoproducto, precio, stock FROM productos WHERE (idproducto LIKE'" + busca + "%' OR "
                    + "nombre LIKE'" + busca + "%' OR descripcion LIKE'" + busca + "%' OR "
                    + "tipoproducto LIKE'" + busca + "%' OR precio LIKE'" + busca + "%' OR "
                    + "idproducto LIKE'" + busca + "%') "
                    + "ORDER BY idproducto";
        }
        String datos[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idproducto");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("descripcion");
                datos[3] = rs.getString("tipoproducto");
                datos[4] = rs.getString("precio");
                datos[5] = rs.getString("stock");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(idproducto) FROM productos";

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
        public static int obtenerStock(String idProducto) {
        int c = 0;
        String SQL = "SELECT stock FROM productos WHERE idproducto="+idProducto;

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
