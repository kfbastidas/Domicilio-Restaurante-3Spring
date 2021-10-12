package co.mycompany.restaurante.cliente.domain.patterncommand;

import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.infra.services.RestauranteService;

/**
 *
 * @author kevith Bastidas
 */
public class DeleteCommand extends Command{

    /**
     * Componente a eliminar
     */
    private final Componente componente;
    /**
     * Instancia los servicios del restaurante.
     */
    private final RestauranteService service;
    
    /**
     * Constructor parametrizado
     * @param componente
     */
    public DeleteCommand(Componente componente){
        this.componente = componente;
        service = new RestauranteService();
        this.hasUndo = true;
    }
    /**
     * Elimina el componente con su id
     */
    @Override
    public void execute() {
        service.deleteComponente(componente.getId());
    }
    /**
     * al desaser vuelve agregar el componente que elimino.
     */
    @Override
    public void undo() {
        service.addComponente(componente);
    }
    
    
    
}
