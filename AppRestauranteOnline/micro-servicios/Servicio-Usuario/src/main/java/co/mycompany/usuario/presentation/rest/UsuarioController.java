package co.mycompany.usuario.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import co.mycompany.usuario.domain.entity.Usuario;
import co.mycompany.usuario.domain.service.IUsuarioService;
import co.mycompany.usuario.presentation.rest.exceptions.ResourceNotFoundException;
import co.mycompany.usuario.presentation.rest.exceptions.UsuarioDomainException;
/**
 * Servicios web de usuarios
 * 
 * @author Kevith Felipe Bastidas
 *
 */
@RestController
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;


	/**
	 * Encontrar un usuario por un idUser
	 * 
	 * @param id identificador
	 * @return Usuario en formato json
	 * @throws UsuarioDomainException 
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Usuario findUsuario(@PathVariable String id) throws UsuarioDomainException {
		return this.usuarioService.findById(id);
	}
	
	/**
	 * Actualiza un usuario
	 * 
	 * @param id
	 * @param restaurante
	 * @return
	 * @throws UsuarioDomainException
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Usuario update(@PathVariable String id,@RequestBody Usuario usuario) throws UsuarioDomainException, ResourceNotFoundException {
		return usuarioService.update(id,usuario);
	}
	
	/**
	 * Crea un usuario
	 * @param usuario
	 * @return
	 * @throws UsuarioDomainException
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Usuario create(@RequestBody Usuario usuario) throws UsuarioDomainException {
		return usuarioService.create(usuario);
	}
	
	/**
	 * Elimina un usuario
	 * @param id
	 * @throws UsuarioDomainException
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) throws UsuarioDomainException{
		usuarioService.deleteById(id);
	}
}