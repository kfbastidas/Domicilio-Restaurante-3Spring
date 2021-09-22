package co.mycompany.pedido.access.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.mycompany.pedido.domain.entity.Pedido;


/**
 * Interfaces DAO de pedidos
 *@author Kevith Felipe Bastidas
 *
 */
public interface IPedidoDao extends CrudRepository<Pedido, Long> {
	
	/**
	 * Metodo de la interfaz IPedidoDao que permite retornar
	 * todos los pedidos con un estado determinado
	 * @param estado del pedido
	 * @return pedidos
	 */
	@Query("select p from Pedido p where  p.rest_id = ?1 and p.pe_estado = ?2")
	public List<Pedido> findPedidos(Long rest_id,byte pe_estado);
	
	
	/**
	 * Metodo de la interfaz IPedidoDao que permite retornar
	 * todos los pedidos con un estado determinado
	 * @param estado del pedido
	 * @return pedidos
	 */
	@Query("select p from Pedido p where  p.user_id = ?1")
	public List<Pedido> findPedidos(String user_id);
}