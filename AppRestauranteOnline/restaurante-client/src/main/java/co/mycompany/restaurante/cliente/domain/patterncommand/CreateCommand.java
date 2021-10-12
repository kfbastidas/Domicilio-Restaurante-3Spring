package co.mycompany.restaurante.cliente.domain.patterncommand;

import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.infra.services.RestauranteService;

/**
 * Comando concreto para crear una comida
 *
 * @author Kevith Felipe Bastidas
 */
public class CreateCommand extends Command {

    /**
     * Componente a ser modificada
     */
    private final Componente componente;
    /**
     * Instancia los servicios del restaurante.
     */
    private final RestauranteService service;

    /**
     * Constructor parametrizado
     *
     * @param componente comida crear en la base de datos
     */
    public CreateCommand(Componente componente) {
        this.componente = componente;
        service = new RestauranteService();
        this.hasUndo = true;
    }
    /**
     * adiciona un componente.
     */
    @Override
    public void execute() {
        service.addComponente(componente);
    }
    /**
     * Desase el createCommand por ende elimina el componente agregado.
     */
    @Override
    public void undo() {       
        service.deleteComponente(componente.getId());
    }

}
