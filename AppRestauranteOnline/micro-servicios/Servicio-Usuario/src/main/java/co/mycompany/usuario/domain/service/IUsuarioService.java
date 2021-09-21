package co.mycompany.usuario.domain.service;

import co.mycompany.usuario.domain.entity.Usuario;
import co.mycompany.usuario.presentation.rest.exceptions.ResourceNotFoundException;
import co.mycompany.usuario.presentation.rest.exceptions.UsuarioDomainException;

/**
 * Interfaz de operaciones de la bd de usuarios
 * @author kevith Felipe Bastidas
 *
 */
public interface IUsuarioService {
	
	/**
	 * Recupera un usuario de un id determinado
	 * @param id
	 * @return
	 * @throws UsuarioDomainException
	 */
	public Usuario findById(String id) throws UsuarioDomainException;
	
	/**
	 * Crea un usuario
	 * @param usuario a crear
	 * @return un usuario si se agrego o null de lo contrario
	 * @throws UsuarioDomainException
	 */
	public Usuario create(Usuario usuario) throws UsuarioDomainException;
	
	/**
	 * servicio para actualizar un usuario con un id
	 * @param id
	 * @param usuario
	 * @return el usuario actualizado en caso de no existir retorna null
	 * @throws UsuarioDomainException
	 * @throws ResourceNotFoundException
	 */
	public Usuario update(String id, Usuario usuario) throws UsuarioDomainException, ResourceNotFoundException;

	/**
	 * servicio para eliminar un usuario
	 * @param id
	 * @throws UsuarioDomainException
	 */
	public void deleteById(String id) throws UsuarioDomainException;
	
}
