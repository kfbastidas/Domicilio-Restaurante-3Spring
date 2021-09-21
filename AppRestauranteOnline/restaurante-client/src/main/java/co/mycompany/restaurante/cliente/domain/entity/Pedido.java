/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.restaurante.cliente.domain.entity;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author kevith Felipe Bastidas
 */
public class Pedido implements Serializable {

    private Long pe_id;
    private Long pe_precio;
    private Long pe_cantidad;
    private Calendar pe_fecha;
    private String pe_formaPago;
    private Long pe_estado;
    private Long rest_id;
    private String user_id;

    public Pedido(Long pe_id, Long pe_precio, Long pe_cantidad, Calendar pe_fecha, String pe_formaPago, Long pe_estado, Long rest_id, String user_id) {
        this.pe_id = pe_id;
        this.pe_precio = pe_precio;
        this.pe_cantidad = pe_cantidad;
        this.pe_fecha = pe_fecha;
        this.pe_formaPago = pe_formaPago;
        this.pe_estado = pe_estado;
        this.rest_id = rest_id;
        this.user_id = user_id;
    }

    public Long getPe_id() {
        return pe_id;
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

    public Calendar getPe_fecha() {
        return pe_fecha;
    }

    public void setPe_fecha(Calendar pe_fecha) {
        this.pe_fecha = pe_fecha;
    }

    public String getPe_formaPago() {
        return pe_formaPago;
    }

    public void setPe_formaPago(String pe_formaPago) {
        this.pe_formaPago = pe_formaPago;
    }

    public Long getPe_estado() {
        return pe_estado;
    }

    public void setPe_estado(Long pe_estado) {
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
