/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

public class Usuario {

    public static String LISTAR = "SELECT A.idusuario, A.usuario, CONCAT(B.nombre, ' ', B.apellido) AS trabajador, A.password, A.tipousuario, A.idtrabajador "
              + "FROM usuarios A "
              + "INNER JOIN trabajadores B ON A.idtrabajador = B.idtrabajador "
              + "WHERE A.idusuario != 1 AND A.eliminado = 0 "
              + "ORDER BY A.idusuario";


    public static String REGISTRAR = "INSERT INTO usuarios(idtrabajador, usuario, password, tipousuario) "
            + "VALUES(?,?,?,?)";

    public static String ACTUALIZAR = "UPDATE usuarios SET "
            + "password=? "
            + "WHERE idusuario=?";

    public static String ELIMINAR = "UPDATE usuarios SET eliminado=1 WHERE idusuario = ?";

    private int id;
    private String usuario;
    private String password;
    private String tipo;  
    private String idTrabajador;  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
    
    

}
