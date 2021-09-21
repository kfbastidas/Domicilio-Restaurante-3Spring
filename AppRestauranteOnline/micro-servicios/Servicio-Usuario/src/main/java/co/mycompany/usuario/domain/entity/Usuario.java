package co.mycompany.usuario.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Kevith Felipe Bastidas
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id",nullable = false,unique = true)
	private String id;
	@Column(name = "clave",nullable = false)
	private String clave;
	@Column(name = "nombre",nullable = false)
	private String nombre;
	@Column(name = "direccion",nullable = false)
	private String direccion;
	@Column(name = "telefono",nullable = false)
	private String telefono;
	@Column(name = "tipo",nullable = false)
	private String tipo;
	
	
	/**
	 * Constructor
	 */
	public Usuario() {
	}


	public Usuario(String id, String clave, String nombre, String direccion, String telefono,String tipo) {
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
