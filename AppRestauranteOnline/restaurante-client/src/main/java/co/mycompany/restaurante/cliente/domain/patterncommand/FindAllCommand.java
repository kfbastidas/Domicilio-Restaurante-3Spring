package co.mycompany.restaurante.cliente.domain.patterncommand;
import java.util.ArrayList;
import java.util.List;
import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.infra.services.RestauranteService;

/**
 * Comando concreto para buscar todas las comidas
 *
 * @author Kevith Felipe Bastidas
 */
public class FindAllCommand extends Command {

    /**
     * Lista de comidas, resultado de ejecutar el comando
     */
    private List<Componente> componentes;
    /**
     * Instancia los servicios del restaurante.
     */
    private final RestauranteService service;

    /**
     * Constructor por defecto
     */
    public FindAllCommand() {
        componentes = new ArrayList<>();
        service = new RestauranteService();
        // No tiene deshacer
        this.hasUndo = false;
    }
    /**
     * Metodo del comando que debe ser ejecutado antes de get todos los componentes
     * existentes
     */
    @Override
    public void execute() {         
        componentes = service.getComponentes();
    }
    /**
     * Obtiene todos los componentes existentes
     * @return 
     */
    public List<Componente> getComponentes() {
        return this.componentes;
    }
    /**
     * En este caso no hay un desaser ya que tiene que listar todos los componentes existentes.
     */
    @Override
    public void undo() {
        
    }

}
