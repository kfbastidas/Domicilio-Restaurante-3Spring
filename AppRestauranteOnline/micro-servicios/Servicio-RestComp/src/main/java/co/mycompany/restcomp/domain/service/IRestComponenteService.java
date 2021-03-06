package co.mycompany.restcomp.domain.service;

import java.util.List;

import co.mycompany.restcomp.domain.entity.Componente;
import co.mycompany.restcomp.domain.entity.RestComponente;
import co.mycompany.restcomp.presentation.rest.exceptions.ComponenteDomainException;

/**
 * Interfaz de operaciones de la bd de componente
 * @author kevith Felipe Bastidas
 *
 */
public interface IRestComponenteService {
	
	/**
	 * Encuentra una lista de componentes con el id del restaurante y un dia determinado.
	 * @param id
	 * @param dia
	 * @return
	 * @throws ComponenteDomainException
	 */
	public List<Componente> findComponentes(Long id, String dia) throws ComponenteDomainException;
	
	/**
	 * 
	 * Agrega el id del restaurante junto con el id del componente en un dia determinado
	 * @param componente
	 * @return el componente agregado
	 */
	public RestComponente createComponenteDia(RestComponente restComp) throws ComponenteDomainException;
		
	/**
	 * Elimina el componente de la base de datos
	 * @param id
	 */
	public void deleteComponente(Long idRest,Long idComp, String dia) throws ComponenteDomainException;
}
