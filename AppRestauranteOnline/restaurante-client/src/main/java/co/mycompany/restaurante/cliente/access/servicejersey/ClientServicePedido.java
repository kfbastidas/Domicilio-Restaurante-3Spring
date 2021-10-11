package co.mycompany.restaurante.cliente.access.servicejersey;

import co.mycompany.restaurante.cliente.domain.entity.*;
import co.mycompany.restaurante.cliente.infra.Utilities;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * Permite conectarse al servidor web y consultar la API Rest
 * @author kevith felipe bastidas
 */
public class ClientServicePedido {
    //Atributos
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = Utilities.loadProperty("base.uriPedido");
    /**
     * Constructor por defecto
     */
    public ClientServicePedido() {
    }
    
    private void initPedido(){
        client = ClientBuilder.newClient();
        webTarget = webTarget = client.target(BASE_URI).path("pedido");
    }
    private void close() {
        client.close();
    }
    public List<Pedido> getPedidos(int idRestaurante,int estado)throws ClientErrorException{
        initPedido();
        GenericType<String> listResponseType = new GenericType<String>(){};
        String formato = java.text.MessageFormat.format("{0}/{1}", idRestaurante,estado);
        webTarget = webTarget.path(formato);
        String pedidos = "";
        try {
            pedidos = webTarget.request(MediaType.APPLICATION_JSON).get(listResponseType);
        } catch (Exception e) {
        }
        close();
        return jsonToPedidos(pedidos);
    }
    public List<Pedido> getPedidos(String user_id)throws ClientErrorException{
        initPedido();
        GenericType<String> listResponseType = new GenericType<String>(){};
        String formato = java.text.MessageFormat.format("user/{0}", user_id);
        webTarget = webTarget.path(formato);
        String pedidos = "";
        try {
            pedidos = webTarget.request(MediaType.APPLICATION_JSON).get(listResponseType);
        } catch (Exception e) {
        }
        close();
        return jsonToPedidos(pedidos);
    }
    public String addPedido(Pedido requestEntity) throws ClientErrorException {
        requestEntity.setPe_plato(convertToJson(requestEntity.getComponentes()));
        initPedido();
        try {
            webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), String.class);
            close();
            return "Pedido añadido correctamente";
        } catch (Exception e) {
            close();
            return "Error, el pedido no se añadio correctamente";
        }
    }
    
    public String deletePedido(int pe_id){
        initPedido();
        String formato = java.text.MessageFormat.format("{0}", pe_id);
        webTarget = webTarget.path(formato);
        try {
            webTarget.request().delete(String.class);
            close();
            return "Pedido eliminado correctamente";
        } catch (Exception e) {
            close();
            return "Error, el pedido con ese id no existe";
        }
    }
    
    public String updatePedido(int pe_id,Pedido pedido){
        pedido.setPe_plato(convertToJson(pedido.getComponentes()));
        initPedido();
        String formato = java.text.MessageFormat.format("{0}", pe_id);
        webTarget = webTarget.path(formato);
        Object requestEntity = pedido;
        try {
            webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), String.class);
            close();
            return "Pedido actualizado correctamente";
        } catch (Exception e) {
            close();
            return "Error, el pedido no se actualizado correctamente";
        }
    }
    
    private List<Pedido> jsonToPedidos(String jsonLista){
        List<Pedido> listaConvertida = new ArrayList<>();
        
        JsonParser parser = new JsonParser();

        // Obtain Array
        JsonArray gsonArr = parser.parse(jsonLista).getAsJsonArray();
        
        for (JsonElement obj : gsonArr) {
            String jsonPedido = obj.toString();
            Pedido pedido = jsonToPedido(jsonPedido);
            listaConvertida.add(pedido);
        }
        return listaConvertida;
    }
    private Pedido jsonToPedido(String jsonPedido){

        jsonPedido = ""+jsonPedido+"";
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        
        JsonElement obj = parser.parse(jsonPedido).getAsJsonObject();
        JsonObject gsonObj = obj.getAsJsonObject();
        
        String jsonPlatos = gsonObj.get("pe_plato").getAsString();
        String jsonPedido2 = obj.toString();
        Pedido pedido = gson.fromJson(jsonPedido2, Pedido.class);
        pedido.setComponentes(jsonToComponentes(jsonPlatos));
        return pedido;
    }
    private List<Componente> jsonToComponentes(String jsonLista){
        Gson gson = new Gson();
        List<Componente> listaConvertida = new ArrayList<>();
        
        // Obtain Array
        JsonParser parser = new JsonParser();

        // Obtain Array
        JsonArray gsonArr = parser.parse(jsonLista).getAsJsonArray();
        
        for (JsonElement obj : gsonArr) {
            String jsonComponente = obj.toString();
            Componente comp = gson.fromJson(jsonComponente, Componente.class);
            listaConvertida.add(comp);
            
        }
        return listaConvertida;
    }   
     /**
     * Función que convierte un objeto a un formato json 
     * @param food objeto
     * @return String en formato Json
     */
    private String convertToJson(List<Componente> componentes) {
        Gson gson = new Gson();
        String json = gson.toJson(componentes);
        return json;
    }
}
