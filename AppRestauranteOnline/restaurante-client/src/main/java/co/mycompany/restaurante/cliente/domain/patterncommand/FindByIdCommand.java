package co.mycompany.restaurante.cliente.domain.patterncommand;

import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.infra.services.RestauranteService;

/**
 * Comando concreto para buscar una comida por su id
 *
 * @author Kevith Felipe Bastidas
 */
public class FindByIdCommand extends Command {

    /**
     * Componente a ser modificada
     */
    private Componente componente;
    /**
     * id de la comida a buscar
     */
    private int componenteId;
    /**
     * Instancia los servicios del restaurante.
     */
    private final RestauranteService service;

    /**
     * Constructor
     */
    public FindByIdCommand() {
        service = new RestauranteService();
        //No tiene deshacer
        this.hasUndo = false;
    }
    /**
     * Encuentra el componente con su respectivo id
     */
    @Override
    public void execute() {         
        componente = service.getComponente(componenteId);
    }
    /**
     * Como es consulta no tiene un desaser
     */
    @Override
    public void undo() {
        
    }
    /**
     * Obtiene el componente encontrado
     * @return 
     */
    public Componente getComponente() {
        return componente;
    }
    /**
     * Obtiene el id del componente.
     * @return 
     */
    public int getComponenteId() {
        return componenteId;
    }
    /**
     * Actualiza el id del componente.
     * @param componenteId 
     */
    public void setComponenteId(int componenteId) {
        this.componenteId = componenteId;
    }

}
