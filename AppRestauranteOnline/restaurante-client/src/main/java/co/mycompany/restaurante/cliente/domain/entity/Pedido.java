/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.restaurante.cliente.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevith Felipe Bastidas
 */
public class Pedido implements Serializable {

    private int pe_id;
    private int pe_precio;
    private int pe_cantidad;
    private String pe_fecha;
    private String pe_formapago;
    private byte pe_estado;
    private int rest_id;
    private String user_id;
    private String pe_plato;
    private List<Componente> componentes;

    public Pedido() {
        this.componentes = new ArrayList<>();
        
    }

    public Pedido(int pe_id, int pe_precio, int pe_cantidad, String pe_fecha, String pe_formapago, byte pe_estado, int rest_id, String user_id) {
        this.pe_id = pe_id;
        this.pe_precio = pe_precio;
        this.pe_cantidad = pe_cantidad;
        this.pe_fecha = pe_fecha;
        this.pe_formapago = pe_formapago;
        this.pe_estado = pe_estado;
        this.rest_id = rest_id;
        this.user_id = user_id;
    }

    

    
    //gets and sets

    public String getPe_plato() {
        return pe_plato;
    }

    public void setPe_plato(String pe_plato) {
        this.pe_plato = pe_plato;
    }
    
    public int getPe_id() {
        return pe_id;
    }

    public void setPe_id(int pe_id) {
        this.pe_id = pe_id;
    }

    public int getPe_precio() {
        return pe_precio;
    }

    public void setPe_precio(int pe_precio) {
        this.pe_precio = pe_precio;
    }

    public int getPe_cantidad() {
        return pe_cantidad;
    }

    public void setPe_cantidad(int pe_cantidad) {
        this.pe_cantidad = pe_cantidad;
    }

    public String getPe_fecha() {
        return pe_fecha;
    }

    public void setPe_fecha(String pe_fecha) {
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

    public int getRest_id() {
        return rest_id;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    @Override
    public String toString() {
        return "Pedido{" + "pe_id=" + pe_id + ", pe_precio=" + pe_precio + ", pe_cantidad=" + pe_cantidad + ", pe_fecha=" + pe_fecha + ", pe_formapago=" + pe_formapago + ", pe_estado=" + pe_estado + ", rest_id=" + rest_id + ", user_id=" + user_id + ", componentes=" + componentes + '}';
    }
    
}
