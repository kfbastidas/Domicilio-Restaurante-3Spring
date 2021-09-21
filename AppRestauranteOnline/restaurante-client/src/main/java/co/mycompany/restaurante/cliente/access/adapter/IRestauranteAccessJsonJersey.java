package co.mycompany.restaurante.cliente.access.adapter;

import co.mycompany.restaurante.cliente.domain.entity.Componente;
import java.util.List;

/**
 *
 * @author Kevith Felipe Bastidas
 */
public interface IRestauranteAccessJsonJersey {
    public Componente getComponente(int comp_id);
    /**
    * Obtener todos los componentes
    * @return  Lista de componentes
    */
    public List<String> getComponentes();
    /**
     * Agregar un componente
     * @param componente
     * @return 
     */
    public boolean addComponente(Componente componente);
    /**
     * Modificar un componente
     * @param componente
     * @return 
     */
    public boolean modify(Componente componente);

    /**
     * Elimina un componente
     * @param id 
     */
    public void remove(int id);
}
