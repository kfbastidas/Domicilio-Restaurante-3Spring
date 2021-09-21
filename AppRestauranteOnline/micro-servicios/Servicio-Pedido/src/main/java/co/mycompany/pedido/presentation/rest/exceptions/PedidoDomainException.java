package co.mycompany.pedido.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un plato
 * 
 * * @author Kevith Felipe Bastidas
 *
 */
public class PedidoDomainException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Listado de errores
	 */
	public final List<PedidoError> errors;

	public PedidoDomainException(List<PedidoError> errors) {
		this.errors = errors;
	}
}
