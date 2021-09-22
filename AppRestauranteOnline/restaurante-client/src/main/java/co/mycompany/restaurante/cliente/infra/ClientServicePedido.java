package co.mycompany.restaurante.cliente.infra;

import co.mycompany.restaurante.cliente.domain.entity.*;
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
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * Permite conectarse al servidor web y consultar la API Rest
 * @author kevith felipe bastidas
 */
public class ClientServicePedido {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = Utilities.loadProperty("base.uriPedido");
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
}