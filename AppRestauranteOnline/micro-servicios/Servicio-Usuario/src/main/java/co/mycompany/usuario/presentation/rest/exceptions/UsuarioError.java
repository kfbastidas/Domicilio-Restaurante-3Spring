package co.mycompany.usuario.presentation.rest.exceptions;

import co.mycompany.usuario.domain.service.EnumErrorCodes;

/**
 * Error de un Componente
 * 
 * * @author Kevith Felipe Bastidas
 *
 */
public class UsuarioError {
	/**
	 * Codigo del error
	 */
	public final EnumErrorCodes code;
	/**
	 * Campo del error
	 */
	public final String field;
	/**
	 * Descripción del error 
	 */
	public final String description;

	public UsuarioError(EnumErrorCodes code, String field, String description) {
		this.code = code;
		this.field = field;
		this.description = description;
	}
}
