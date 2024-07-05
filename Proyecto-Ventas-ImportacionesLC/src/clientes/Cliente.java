/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

public class Cliente {

    public static String LISTAR = "SELECT * FROM clientes ORDER BY apellido WHERE eliminado = 0";
    public static String REGISTRAR = "INSERT INTO clientes(nombre, apellido, direccion, telefono, email) "
            + "VALUES(?,?,?,?,?)";
    public static String ACTUALIZAR = "UPDATE clientes SET "
            + "nombre=?, "
            + "apellido=?, "
            + "direccion=?, "
            + "telefono=?, "
            + "email=? "
            + "WHERE idcliente=?";
    public static String ELIMINAR = "UPDATE clientes SET eliminado = 1 WHERE idcliente = ?";
    public static String ELIMINAR_TODO = "TRUNCATE TABLE clientes";

    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

