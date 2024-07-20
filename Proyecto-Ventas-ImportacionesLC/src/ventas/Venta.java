/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;


public class Venta {
    public static String LISTAR = "SELECT A.idventa, A.idcliente, CONCAT(B.nombre, ' ', B.apellido) AS cliente, "
            + "A.idusuario, CONCAT(D.nombre, ' ', D.apellido) AS trabajador, A.fecha, "
            + "SUM(E.cantidad * E.precio_unitario) AS total "
            + "FROM ventas A INNER JOIN clientes B ON A.idcliente = B.idcliente "
            + "INNER JOIN usuarios C ON A.idusuario = C.idusuario "
            + "INNER JOIN trabajadores D ON C.idtrabajador = D.idtrabajador "
            + "INNER JOIN detalle_ventas E ON A.idventa = E.idventa "
            + "WHERE A.eliminado = 0 "
            + "AND E.eliminado = 0 "
            + "GROUP BY A.idventa, A.idcliente, cliente, A.idusuario, trabajador, A.fecha "
            + "ORDER BY A.fecha";
   
    public static String REGISTRAR = "INSERT INTO ventas(idcliente, idusuario, fecha) VALUES(?,?,?)";
    public static String ACTUALIZAR = "UPDATE ventas SET idcliente=?, idusuario=?, fecha=?, total=? WHERE idventa=?";
    public static String ELIMINAR = "UPDATE ventas SET eliminado = 1 WHERE idventa = ?";
    public static String ELIMINAR_TODO = "TRUNCATE TABLE ventas";

    private int idventa;
    private int idcliente;
    private int idusuario;
    private String fecha;
 

    // Getters y Setters
    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Venta{" + "idventa=" + idventa + ", idcliente=" + idcliente + ", idusuario=" + idusuario + ", fecha=" + fecha + '}';
    }
    
    
}
