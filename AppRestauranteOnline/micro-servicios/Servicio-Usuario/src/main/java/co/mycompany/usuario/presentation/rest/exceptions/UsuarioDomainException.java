package co.mycompany.usuario.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un componente de un plato
 * 
 * * @author Kevith Felipe Bastidas
 *
 */
public class UsuarioDomainException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Listado de errores
	 */
	public final List<UsuarioError> errors;

	public UsuarioDomainException(List<UsuarioError> errors) {
		this.errors = errors;
	}
}
