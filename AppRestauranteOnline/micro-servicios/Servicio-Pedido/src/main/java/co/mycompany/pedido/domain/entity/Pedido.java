package co.mycompany.pedido.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa un pedido de un respectivo cliente. Mapeado con la bd.
 * 
 * @author Kevith Felipe Bastidas
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pe_id;

	@Column(name = "pe_precio")
	private Long pe_precio;
	
	@Column(name = "pe_cantidad")
	private Long pe_cantidad;

	@Column(name = "pe_fecha")
    @Temporal(TemporalType.DATE)
	private Date pe_fecha;
	
	@Column(name = "pe_formapago")
	private String pe_formapago;
	
	@Column(name = "pe_estado")
	private byte pe_estado;
	
	@Column(name = "rest_id")
	private Long rest_id;
	
	@Column(name = "user_id")
	private String user_id;
	
	@Column(name = "pe_plato")
	private String pe_plato;
	
	//gets and sets
	
	
	public Long getPe_id() {
		return pe_id;
	}

	public String getPe_plato() {
		return pe_plato;
	}

	public void setPe_plato(String pe_plato) {
		this.pe_plato = pe_plato;
	}

	public void setPe_id(Long pe_id) {
		this.pe_id = pe_id;
	}
	
	public Long getPe_precio() {
		return pe_precio;
	}

	public void setPe_precio(Long pe_precio) {
		this.pe_precio = pe_precio;
	}

	public Long getPe_cantidad() {
		return pe_cantidad;
	}

	public void setPe_cantidad(Long pe_cantidad) {
		this.pe_cantidad = pe_cantidad;
	}

	public Date getPe_fecha() {
		return pe_fecha;
	}

	public void setPe_fecha(Date pe_fecha) {
		this.pe_fecha = pe_fecha;
	}

	

	public String getPe_formapago() {
		return pe_formapago;
	}

	public void setPe_formapago(String pe_formapago) {
		this.pe_formapago = pe_formapago;
	}

	public byte getPe_estado() {
		return pe_estado;
	}

	public void setPe_estado(byte pe_estado) {
		this.pe_estado = pe_estado;
	}

	public Long getRest_id() {
		return rest_id;
	}

	public void setRest_id(Long rest_id) {
		this.rest_id = rest_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}