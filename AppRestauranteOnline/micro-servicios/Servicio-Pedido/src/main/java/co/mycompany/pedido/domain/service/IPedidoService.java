package co.mycompany.pedido.domain.service;
import java.util.List;
import co.mycompany.pedido.domain.entity.Pedido;
import co.mycompany.pedido.presentation.rest.exceptions.PedidoDomainException;
import co.mycompany.pedido.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Interfaz de operaciones de la bd de pedido
 * 
 * @author Kevith Felipe Bastidas
 *
 */

public interface IPedidoService {
	
	/**
	 * Encuentra todos los pedidos de la base de datos de un determinado estado y restaurante.
	 * @return todos los pedidos encontrados de un terminado restaurante y estado
	 */
	public List<Pedido> findPedidos(Long rest_id,byte pe_estado);
	
	/**
	 * Encuentra todos los pedidos de la base de datos de un determinado usuario.
	 * @return todos los pedidos encontrados de un terminado restaurante y estado
	 */
	public List<Pedido> findPedidos(String user_id);

	public Pedido create(Pedido pedido) throws PedidoDomainException;

	public Pedido update(Long pe_id, Pedido pedido) throws PedidoDomainException;

	public void delete(Long pe_id) throws ResourceNotFoundException;
}
