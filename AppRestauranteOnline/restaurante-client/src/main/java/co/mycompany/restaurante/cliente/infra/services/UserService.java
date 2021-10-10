package co.mycompany.restaurante.cliente.infra.services;
import co.mycompany.restaurante.cliente.access.Factory;
import co.mycompany.restaurante.cliente.domain.TipoUser;
import co.mycompany.restaurante.cliente.domain.User;
import co.mycompany.restaurante.cliente.domain.entity.Usuario;
import static co.mycompany.restaurante.cliente.infra.Messages.successMessage;
import co.mycompany.restaurante.cliente.infra.Security;
/**
 * Servicio de usuarios del sistema
 * @author Kevith Felipe Bastidas
 */
public class UserService {
    
    /**
     * autentica el usuario si y solo si existe el username y la contraseña
     * es correcta.
     * @param username nombre de usuario
     * @param password constraseña
     * @return true si inicio seccion, false si no inicio seccion
     */
    public static boolean autenticacion(String username, String password) {
        
        if (!validarUser(username, password)) {
            return false;
        }
        
        Usuario user = Factory.getInstance().getRestauranteService().getUsuario(username);
        
        if (user!=null) {
            if (user.getClave().equals(password)) {
                TipoUser tipo = null;
                switch (user.getTipo()) {
                    case "A": {
                        tipo = TipoUser.ADMINISTRADOR;
                        break;
                    }
                    case "C": {
                        tipo = TipoUser.CLIENTE;
                        break;
                    }
                }
                User user2 = new User(tipo, user.getNombre().toUpperCase(), user.getClave(), username);
                Security.usuario = user2;
                return true;
            }
            successMessage("Password Incorrecto.", "Atención");
            return false;
        }
        ponerUserInvitado();
        successMessage("Username no existe.", "Atención");
        return false;
    }   
    /**
     * Valida que el username y password no esten vacidos
     * @param username
     * @param password
     * @return 
     */
    public static boolean validarUser(String username, String password){       
        if (username.equals("")) {
            successMessage("Username Incorrecto.", "Atención");
            return false;
        }
        if (password.equals("")) {
            successMessage("Password Incorrecto.", "Atención");
            return false;
        }
        return true;
    }
    
    /**
     * Pone el usuario como visitante
     */
    public static void ponerUserInvitado(){
        Security.usuario = new User(TipoUser.VISITANTE, "VISITANTE", "","");
    }
}
