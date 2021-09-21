package co.mycompany.usuario.domain.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.mycompany.usuario.access.dao.IUsuarioDao;
import co.mycompany.usuario.domain.entity.Usuario;
import co.mycompany.usuario.presentation.rest.exceptions.ResourceNotFoundException;
import co.mycompany.usuario.presentation.rest.exceptions.UsuarioDomainException;
import co.mycompany.usuario.presentation.rest.exceptions.UsuarioError;

/**
 * Implementa los servicios de los usuarios
 * @author kevith Felipe Bastidas
 *
 */
@Service
public class UsuarioImplService implements IUsuarioService{
	/**
	 * Inyeccion de usuario dao
	*/
	@Autowired
	private IUsuarioDao usuarioDao;
	
	
	/**
	 * Servicio para buscar usuario por ID
	 * 
	 * @param id del Usuario
	 * @return Usuario
	 */
	@Override
	public Usuario findById(String id) throws UsuarioDomainException {		
		Usuario usuario = this.usuarioDao.findById(id).orElse(null);
		List<UsuarioError> errors = validateDomain(usuario);
		
		if(!errors.isEmpty()) {
			throw new UsuarioDomainException(errors);
		}
		return usuario;
	}
	
	/**
	 * servicio para agregar un usuario por ID
	 */
	@Override
	public Usuario create(Usuario usuario) throws UsuarioDomainException{
		List<UsuarioError> errors = validateCreate(usuario);	
		if(!errors.isEmpty()) {
			throw new UsuarioDomainException(errors);
		}
		return this.usuarioDao.save(usuario);
	}
	
	/**
	 * servicio para actualizar un usuario con un id
	 * @param id
	 * @param usuario
	 * @return el usuario actualizado en caso de no existir retorna null
	 * @throws UsuarioDomainException
	 * @throws ResourceNotFoundException
	 */
	public Usuario update(String id, Usuario usuario) throws UsuarioDomainException, ResourceNotFoundException{
		Usuario usuarioUpdate = this.findById(id);
		if (usuarioUpdate==null) {
			throw new ResourceNotFoundException();
		}
		
		List<UsuarioError> errors = validateDomain(usuarioUpdate);	
		if(!errors.isEmpty()) {
			throw new UsuarioDomainException(errors);
		}
		
		usuarioUpdate.setClave(usuario.getClave());
		usuarioUpdate.setDireccion(usuario.getDireccion());
		usuarioUpdate.setNombre(usuario.getNombre());
		usuarioUpdate.setTelefono(usuario.getTelefono());
		usuarioUpdate.setTipo(usuario.getTipo());
		
		return this.usuarioDao.save(usuarioUpdate);
	}

	/**
	 * servicio para eliminar un usuario
	 * @param id
	 * @throws UsuarioDomainException
	 */
	public void deleteById(String id) throws UsuarioDomainException{
		Usuario usuario = this.findById(id);
		
		List<UsuarioError> errors = validateDomain(usuario);	
		if(!errors.isEmpty()) {
			throw new UsuarioDomainException(errors);
		}
		
		this.usuarioDao.delete(usuario);
		
	}
	
	
	
	/**
	 * Valida las reglas del dominio para las operaciones requeridas.
	 * @param usuario que se desea validar 
	 * @return lista de errores al valdidar
	 */
	private List<UsuarioError> validateDomain(Usuario usuario) throws UsuarioDomainException{
		List<UsuarioError> errors = new ArrayList<>();
		
		if (usuario == null) {
			errors.add(new UsuarioError(EnumErrorCodes.NOT_FOUND, "idUser", "No existe IDUSER"));
		}else {
			if (usuario.getId().equals("")) {
				errors.add(new UsuarioError(EnumErrorCodes.INVALID_IDUSER, "idUser",
						"El idUser no puede ser vacio"));
			}
		}
		return errors;
	}

	/**
	 * Valida las reglas del dominio para las operaciones requeridas.
	 * @param usuario que se desea validar 
	 * @return lista de errores al valdidar
	 */
	private List<UsuarioError> validateCreate(Usuario usuario) throws UsuarioDomainException{
		List<UsuarioError> errors = new ArrayList<>();
		Usuario usuarioExiste = this.usuarioDao.findById(usuario.getId()).orElse(null);
		if (usuarioExiste != null) {
			errors.add(new UsuarioError(EnumErrorCodes.FOUND, "idUser", "Ya existe IDUSER"));
		}
		return errors;
	}
	
}
