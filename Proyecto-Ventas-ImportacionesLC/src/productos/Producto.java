/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

public class Producto {

    public static String LISTAR = "SELECT idproducto, nombre, descripcion, tipoproducto, precio, stock FROM productos WHERE eliminado = 0 ORDER BY tipoproducto";
    public static String LISTAR_AL = "SELECT idproducto, nombre, descripcion, tipoproducto, precio, stock FROM productos WHERE eliminado = 0 AND stock!='' ORDER BY tipoproducto";

    public static String REGISTRAR = "INSERT INTO productos(nombre, descripcion, tipoproducto, precio, stock) "
            + "VALUES(?,?,?,?,?)";

    public static String ACTUALIZAR = "UPDATE productos SET "
            + "nombre=?, "
            + "descripcion=?, "
            + "tipoproducto=?, "
            + "precio=?, "
            + "stock=? "
            + "WHERE idproducto=?";
    
    public static String ACTUALIZAR_STOCK = "UPDATE productos SET "
            + "stock=? "
            + "WHERE idproducto=?";

    public static String ELIMINAR = "UPDATE productos SET eliminado = 1 WHERE idproducto = ?";

    public static String ELIMINAR_TODO = "TRUNCATE TABLE productos";

    private int id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private double precio;
    private String stock;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

}
