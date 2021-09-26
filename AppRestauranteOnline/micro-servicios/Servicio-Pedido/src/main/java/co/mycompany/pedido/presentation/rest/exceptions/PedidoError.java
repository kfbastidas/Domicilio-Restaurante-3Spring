package co.mycompany.pedido.presentation.rest.exceptions;

import co.mycompany.pedido.domain.service.EnumErrorCodes;

/**
 * Error de un plato
 * 
 * * @author Kevith Felipe Bastidas 
 *
 */
public class PedidoError {
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

	public PedidoError(EnumErrorCodes code, String field, String description) {
		this.code = code;
		this.field = field;
		this.description = description;
	}
}
