package co.mycompany.restaurante.cliente.domain.patterncommand;

import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.infra.Messages;
import co.mycompany.restaurante.cliente.infra.services.RestauranteService;

/**
 * Comando concreto para modificar una comida
 *
 * @author Kevith Felipe Bastidas
 */
public class UpdateCommand extends Command {

    /**
     * Componente a ser modificada
     */
    private final Componente componente;
    /**
     * Componente previo, que permitirá deshacer la operación de modificar
     */
    private Componente componentePrevious;
    /**
     * Instancia los servicios del restaurante.
     */
    private final RestauranteService service;

    /**
     * Constructor parametrizado
     * @param componente comida a modificar
     */
    public UpdateCommand(Componente componente) {
        this.componente = componente;
        service = new RestauranteService();
        this.hasUndo = true;
    }
    /**
     * Actualiza el componente
     */
    @Override
    public void execute() {    
        String respuesta = service.updateComponente(componente.getId(), componente);
        if (respuesta.equals("Componente actualizado correctamente")) {
            Messages.successMessage(respuesta, "Información");
        }else{
            Messages.errorMessage(respuesta, "Atención");
        }
    }
    /**
     * Desase la actualizacion del componente que actualizo anteriormente.
     */
    @Override
    public void undo() {            
        service.updateComponente(componentePrevious.getId(), componentePrevious);
    }
    /**
     * Obtiene el componente previos.
     * @return 
     */
    public Componente getFoodPrevious() {
        return componentePrevious;
    }
    /**
     * Modifica el componentePrevious.
     * @param componentePrevious 
     */
    public void setFoodPrevious(Componente componentePrevious) {
        this.componentePrevious = componentePrevious;
    }

}
