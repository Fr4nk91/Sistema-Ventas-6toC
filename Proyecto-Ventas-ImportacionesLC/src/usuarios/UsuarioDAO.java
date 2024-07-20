/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import login.FormLogin;
import principal.Escritorio;


public class UsuarioDAO {

    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(Usuario uc) {
        int rsu = 0;
        String sql = Usuario.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getIdTrabajador());
            ps.setString(2, uc.getUsuario());
            ps.setString(3, uc.getPassword());
            ps.setString(4, uc.getTipo());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(Usuario uc) {
        int rsu = 0;
        String sql = Usuario.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getPassword());
            ps.setInt(2, uc.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminar(int id) {
        int rsu = 0;
        String sql = Usuario.ELIMINAR;

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
        DefaultTableModel modelo = (DefaultTableModel) FormUsuarios.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Usuario.LISTAR;
        } else {
         sql = "SELECT A.idusuario, A.usuario,  CONCAT(B.nombre, ', ', B.apellido) AS trabajador, A.password, A.tipousuario, A.idtrabajador "
           + "FROM usuarios A "
           + "INNER JOIN trabajadores B ON A.idtrabajador = B.idtrabajador "
           + "WHERE (A.idusuario LIKE '" + busca + "%' OR "
           + "A.usuario LIKE '" + busca + "%' OR B.nombre  LIKE '" + busca + "%' OR B.apellido LIKE '" + busca + "%' OR A.password LIKE '" + busca + "%' OR "
           + "A.tipousuario LIKE '" + busca + "%') AND A.idusuario != 1 "
           + "ORDER BY A.idusuario";
        }
        String datos[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idusuario");
                datos[1] = rs.getString("usuario");
                datos[2] = rs.getString("trabajador");
                datos[3] = rs.getString("password");
                datos[4] = rs.getString("tipousuario");
                datos[5] = rs.getString("idtrabajador");
      
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean verificaUsuario(String usuario) {
        boolean existe = false;
        String user = "";
        try {
            String sql = "SELECT idusuario, idtrabajador, usuario, password, tipousuario  FROM usuarios WHERE usuario = '" + usuario + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                user = rs.getString(3);
            }

            if (user.equals(usuario)) {
                existe = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }

    public static void verifica(String usuario, String pas, JFrame login) {
        String user = "", pass = "", tipo_us = "";
        String idUsuario = "";
        try {
            String sql = "SELECT idusuario, idtrabajador, usuario, password, tipousuario FROM usuarios WHERE usuario = '" + usuario + "' AND eliminado=0";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                idUsuario = rs.getString(1);
                user = rs.getString(3);
                pass = rs.getString(4);
                tipo_us = rs.getString(5);
            }

            if (user.equals(usuario) && pass.equals(pas)) {
                if (tipo_us.equals("ADMINISTRADOR")) {
                    login.dispose();
                    Escritorio.idUsuario = idUsuario;
                    Escritorio.usuario = usuario;
                    new principal.FormPrincipalAdministrador().setVisible(true);
                }

                if (tipo_us.equals("NORMAL")) {
                    login.dispose();
                    Escritorio.idUsuario = idUsuario;
                    Escritorio.usuario = usuario;
                    new principal.FormPrincipal().setVisible(true);
                }
            } else {
                FormLogin.info.setText("¡ USUARIO O CONTRASEÑA INCORRECTOS !");
                FormLogin.txtUsuario.setText("");
                FormLogin.txtPassword.setText("");
                FormLogin.txtUsuario.requestFocus();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void listarTrabajadores(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) FormTrabajadoresUsuario.tabla.getModel();
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
