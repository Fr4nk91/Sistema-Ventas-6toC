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
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDAO {
    static ConexionBD cc = new ConexionBD();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    // Método para registrar un nuevo detalle de venta
    public static int registrar(DetalleVenta dv) {
        int rsu = 0;
        String sql = DetalleVenta.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, dv.getIdventa());
            ps.setInt(2, dv.getIdproducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecio_unitario());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    // Método para actualizar un detalle de venta existente
    public static int actualizar(DetalleVenta dv) {
        int rsu = 0;
        String sql = DetalleVenta.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, dv.getIdproducto());
            ps.setInt(2, dv.getCantidad());
            ps.setDouble(3, dv.getPrecio_unitario());
            ps.setInt(4, dv.getIddetalle_venta());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    // Método para listar todos los detalles de ventas
    public static List<DetalleVenta> listar() {
        List<DetalleVenta> lista = new ArrayList<>();
        String sql = DetalleVenta.LISTAR;
        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetalleVenta dv = new DetalleVenta();
                dv.setIddetalle_venta(rs.getInt("iddetalle_venta"));
                dv.setIdventa(rs.getInt("idventa"));
                dv.setIdproducto(rs.getInt("idproducto"));
                dv.setCantidad(rs.getInt("cantidad"));
                dv.setPrecio_unitario(rs.getDouble("precio_unitario"));
                lista.add(dv);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return lista;
    }

    // Método para eliminar un detalle de venta por su ID
    public static int eliminar(int iddetalle_venta) {
        int rsu = 0;
        String sql = DetalleVenta.ELIMINAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, iddetalle_venta);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    // Método para eliminar todos los detalles de ventas
    public static void eliminarTodo() {
        String sql = DetalleVenta.ELIMINAR_TODO;
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
    }
}
