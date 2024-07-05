/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salidas;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rojeru San CL
 */
public class Salida {

    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(SalidaDAO uc) {
        int rsu = 0;
        String sql = SalidaDAO.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getDescripcion());
            ps.setDouble(2, uc.getGastado());
            ps.setString(3, uc.getFecha());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(SalidaDAO uc) {
        int rsu = 0;
        String sql = SalidaDAO.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getDescripcion());
            ps.setDouble(2, uc.getGastado());
            ps.setString(3, uc.getFecha());
            ps.setInt(4, uc.getIdgasto());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = SalidaDAO.ELIMINAR;

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
        String sql = SalidaDAO.ELIMINAR_TODO;

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

    public static void totalGastos() {
        int filas = salidas.FormSalidas.tabla.getRowCount();
        double totalE = 0.0;
        for (int i = 0; i < filas; i++) {
            totalE = totalE + Double.parseDouble(salidas.FormSalidas.tabla.getValueAt(i, 1).toString());
        }
        salidas.FormSalidas.lblTotal1.setText(String.valueOf(totalE));
    }
    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) FormSalidas.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = SalidaDAO.LISTAR;
            FormSalidas.descripcion.setText("");
        } else {
            sql = "SELECT * FROM gastos WHERE (idgasto LIKE'" + busca + "%' OR "
                    + "descripcion LIKE'" + busca + "%' OR "
                    + "gastado LIKE'" + busca + "%' OR fecha_gasto LIKE'" + busca + "%') "
                    + "ORDER BY fecha_gasto";
            FormSalidas.descripcion.setText("");
        }
        String datos[] = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idgasto");
                datos[1] = rs.getString("gastado");
                datos[2] = rs.getString("fecha_gasto");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Salida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void extraerDescripcion(String id) {
        String c = null;
        String SQL = "SELECT * FROM gastos WHERE idgasto = "+id;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString(2);
            }
            System.out.println(c);           
            FormSalidas.descripcion.setText(c);

        } catch (SQLException ex) {
            Logger.getLogger(Salida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
