package co.mycompany.restaurante.cliente.domain.entity;

import java.io.Serializable;

/**
 *
 * @author kevit
 */
public class Usuario implements Serializable {

    private String id;
    private String clave;
    private String nombre;
    private String direccion;
    private String telefono;
    private String tipo;

    /**
     * Constructor
     */
    public Usuario() {
    }

    public Usuario(String id, String clave, String nombre, String direccion, String telefono, String tipo) {
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    /**
     * Gets and Sets
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
