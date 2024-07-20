/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

public class DetalleVenta {
    
    
    public static String LISTAR = "SELECT A.iddetalle_venta, A.idventa, A.idproducto, B.nombre, A.cantidad, A.precio_unitario,A.cantidad * A.precio_unitario AS total  "
            + "FROM detalle_ventas A "
            + "INNER JOIN productos B "
            + "ON A.idproducto = B.idproducto"
            + " WHERE A.idventa = ? ORDER BY A.iddetalle_venta";
    
    public static String REGISTRAR = "INSERT INTO detalle_ventas(idventa, idproducto, cantidad, precio_unitario) VALUES(?,?,?,?)";
    public static String ACTUALIZAR = "UPDATE detalle_ventas SET idproducto=?, cantidad=?, precio_unitario=? WHERE iddetalle_venta=?";
    public static String ELIMINAR = "UPDATE detalle_ventas SET eliminado = 1 WHERE iddetalle_venta = ?";
    public static String ELIMINAR_TODO = "TRUNCATE TABLE detalle_ventas";

    private int iddetalle_venta;
    private int idventa;
    private int idproducto;
    private int cantidad;
    private double precio_unitario;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Getters y setters
    public int getIddetalle_venta() {
        return iddetalle_venta;
    }

    public void setIddetalle_venta(int iddetalle_venta) {
        this.iddetalle_venta = iddetalle_venta;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "iddetalle_venta=" + iddetalle_venta + ", idventa=" + idventa + ", idproducto=" + idproducto + ", cantidad=" + cantidad + ", precio_unitario=" + precio_unitario + ", nombre=" + nombre + '}';
    }
    
    
}
