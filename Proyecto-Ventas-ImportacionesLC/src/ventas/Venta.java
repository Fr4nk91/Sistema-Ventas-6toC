/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;


public class Venta {
    public static String LISTAR = "SELECT * FROM ventas ORDER BY fecha";
    public static String LISTAR1 = "SELECT * FROM ventas, producto WHERE id_producto = idproducto";
    public static String REGISTRAR = "INSERT INTO ventas(idventa, idcliente, idusuario, fecha, total) VALUES(?,?,?,?,?)";
    public static String ACTUALIZAR = "UPDATE ventas SET idcliente=?, idusuario=?, fecha=?, total=? WHERE idventa=?";
    public static String ELIMINAR = "DELETE FROM ventas WHERE idventa = ?";
    public static String ELIMINAR_TODO = "TRUNCATE TABLE ventas";

    private int idventa;
    private int idcliente;
    private int idusuario;
    private String fecha;
    private double total;

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
