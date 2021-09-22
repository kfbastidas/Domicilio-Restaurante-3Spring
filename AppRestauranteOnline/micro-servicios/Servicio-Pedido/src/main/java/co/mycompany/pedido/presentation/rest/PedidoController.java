package co.mycompany.pedido.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.mycompany.pedido.domain.entity.Pedido;
import co.mycompany.pedido.domain.service.IPedidoService;
import co.mycompany.pedido.presentation.rest.exceptions.PedidoDomainException;
import co.mycompany.pedido.presentation.rest.exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;

/**
 * Servicios web de pedidos
 * 
 * @author Kevith Felipe Bastidas
 *
 */
@RestController
@RequestMapping("pedido")
public class PedidoController {
	@Autowired
	private IPedidoService pedidoService;

	/**
	 * Encuentra los pedidos de un id de restaurante en un estado determinado
	 * @param rest_id
	 * @param pe_estado
	 * @throws PedidoDomainException
	 */
	@RequestMapping(value = "{rest_id}/{pe_estado}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Pedido> findPedidos(@PathVariable Long rest_id,@PathVariable byte pe_estado) throws PedidoDomainException {
		return pedidoService.findPedidos(rest_id, pe_estado);
	}	
	
	/**
	 * Encuentra los pedidos de un id de usuario determinado
	 * @param rest_id
	 * @param pe_estado
	 * @throws PedidoDomainException
	 */
	@RequestMapping(value = "user/{user_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Pedido> findPedidos(@PathVariable String user_id) throws PedidoDomainException {
		return pedidoService.findPedidos(user_id);
	}
	
	/**
	 * Crea un pedido
	 * @param pedido
	 * @return pedido en caso correcto de lo contrario nulo
	 * @throws PedidoDomainException
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Pedido create(@RequestBody Pedido pedido) throws PedidoDomainException {
		return pedidoService.create(pedido);
	}

	/**
	 * Actualiza un pedido de su pe_id
	 * @param pe_id
	 * @param pedido
	 * @return pedido
	 * @throws PedidoDomainException
	 */
	@RequestMapping(value = "{pe_id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Pedido update(@PathVariable Long pe_id, @RequestBody Pedido pedido) throws PedidoDomainException {
		return pedidoService.update(pe_id, pedido);
	}

	/**
	 * Desactivar un plato
	 * @param idRest
	 * @param dia
	 * @throws PedidoDomainException
	 */
	@RequestMapping(value = "{pe_id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long pe_id) throws ResourceNotFoundException {
		pedidoService.delete(pe_id);
	}
}