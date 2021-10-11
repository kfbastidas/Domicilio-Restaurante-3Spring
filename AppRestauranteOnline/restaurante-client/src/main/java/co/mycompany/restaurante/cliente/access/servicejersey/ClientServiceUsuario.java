package co.mycompany.restaurante.cliente.access.servicejersey;
import co.mycompany.restaurante.cliente.domain.entity.Usuario;
import co.mycompany.restaurante.cliente.infra.Utilities;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Permite conectarse al servidor web y consultar la API Rest
 * @author Kevith Bastidas
 */
public class ClientServiceUsuario {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = Utilities.loadProperty("base.uriUsuario");

    public ClientServiceUsuario() {
    }
    
    private void initUsuario(){
        client = ClientBuilder.newClient();
        webTarget = webTarget = client.target(BASE_URI).path("usuario");
    }
    
    private void close() {
        client.close();
    }
    
    public Usuario getUsuario(String user_id){
        initUsuario();
        String formato = java.text.MessageFormat.format("{0}", user_id);
        webTarget = webTarget.path(formato);
        Class<Usuario> responseType = Usuario.class;
        Usuario dato=null;
        try {
            dato = webTarget.request(MediaType.APPLICATION_JSON).get(responseType);
        } catch (Exception e) {
        }
        close();
        return dato;
    }
    
}
