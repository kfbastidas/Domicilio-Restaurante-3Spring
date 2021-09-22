/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.restaurante.server.access;

import co.mycompany.restaurante.cliente.access.Factory;
import co.mycompany.restaurante.cliente.access.IRestauranteAccess;
import co.mycompany.restaurante.cliente.domain.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevit
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    /**
     * Test obtiene todos los pedidos
     */
    @Test
    public void testGetPedidos() {
        System.out.println("getPedidos");
        
        //instancia el servicio
        IRestauranteAccess service = Factory.getInstance().getRestauranteService();
        int idRestaurante = 1;
        int estado = 0;
        int expResult = 2;
        List<Pedido> result = service.getPedidos(idRestaurante, estado);
        assertTrue(result.size()>=expResult);
    }
    /**
     * Test añade un pedido que no existe
     */
    @Test
    public void testAddPedido() {
        System.out.println("addPedido");
        byte estado = 0;
        int idRestaurante = 1;
        Pedido pedido = new Pedido(0, 6500, 3, null, "PSE", estado, idRestaurante, "prueba");
        List<Componente> lista = new ArrayList<>();
        lista.add(new Componente(2, "frijoles", TipoComponente.PRINCIPIO));
        lista.add(new Componente(6, "sancocho de gallina", TipoComponente.ENTRADA));
        lista.add(new Componente(11, "chuleta de cerdo", TipoComponente.PROTEINA));
        lista.add(new Componente(15, "limonada", TipoComponente.BEBIDA));
        pedido.setComponentes(lista);
        
        
        
        //instancia el servicio
        IRestauranteAccess service = Factory.getInstance().getRestauranteService();
        String expResult = "Pedido añadido correctamente";
        String result = service.addPedido(pedido);
        assertEquals(expResult, result);
        
        List<Pedido> pedidoAEliminar = service.getPedidos("prueba");
        expResult = "Pedido eliminado correctamente";
        result = service.deletePedido(pedidoAEliminar.get(0).getPe_id());
        assertEquals(expResult, result);
        
    }
    /**
     * Test añade un pedido que no existe
     */
    @Test
    public void testUpdatePedido() {
        System.out.println("updatePedido");
        byte estado = 0;
        int idRestaurante = 1;
        Pedido pedidoCrear = new Pedido(0, 6500, 3, null, "PSE", estado, idRestaurante, "prueba");
        List<Componente> lista = new ArrayList<>();
        lista.add(new Componente(2, "frijoles", TipoComponente.PRINCIPIO));
        lista.add(new Componente(6, "sancocho de gallina", TipoComponente.ENTRADA));
        lista.add(new Componente(11, "chuleta de cerdo", TipoComponente.PROTEINA));
        lista.add(new Componente(15, "limonada", TipoComponente.BEBIDA));
        pedidoCrear.setComponentes(lista);
        
        
        //instancia el servicio
        IRestauranteAccess service = Factory.getInstance().getRestauranteService();
        String expResult = "Pedido añadido correctamente";
        String result = service.addPedido(pedidoCrear);
        assertEquals(expResult, result);
        
        expResult = "Pedido actualizado correctamente";
        estado = 1;
        pedidoCrear.setPe_estado(estado);
        result = service.updatePedido(service.getPedidos("prueba").get(0).getPe_id(), pedidoCrear);
        
        assertEquals(expResult, result);
        
        
        List<Pedido> pedidoAEliminar = service.getPedidos("prueba");
        expResult = "Pedido eliminado correctamente";
        result = service.deletePedido(pedidoAEliminar.get(0).getPe_id());
        assertEquals(expResult, result);
        
    }
}
