package co.mycompany.pedido.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.mycompany.pedido.access.dao.IPedidoDao;
import co.mycompany.pedido.domain.entity.Pedido;
import co.mycompany.pedido.presentation.rest.exceptions.PedidoDomainException;
import co.mycompany.pedido.presentation.rest.exceptions.PedidoError;
import co.mycompany.pedido.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Implementación de la Interfaz IPedidoService
 * 
 * @author Kevith Felipe Bastidas  
 *
 */

@Service
public class PedidoImplService implements IPedidoService {
	/**
	 * Inyección de pedido Dao
	 */
	@Autowired
	private IPedidoDao pedidoDao;
	
	/**
	 * Crea un nuevo pedido
	 * 
	 * @param pedido a crear en la bd
	 * @return Pedido creado
	 */
	@Override
	@Transactional
	public Pedido create(Pedido pedido) throws PedidoDomainException {
		List<PedidoError> errors = validateDomain(pedido);
		if (!errors.isEmpty()) {
			throw new PedidoDomainException(errors);
		}
		
		if (pedido.getPe_fecha() == null) {
			pedido.setPe_fecha(new Date());
		}
		
		return pedidoDao.save(pedido);
	}
	
	/**
	 * Modifica o edita un pedido
	 * 
	 * @param id,     identificador del pedido a modificar
	 * @param pedido con los datos a editar
	 * @return Pedido modificado.
	 */
	@Override
	@Transactional
	public Pedido update(Long pe_id, Pedido pedido) throws PedidoDomainException{
		Pedido pedidoUpdate = this.pedidoDao.findById(pe_id).orElse(null);
		List<PedidoError> errors = validateDomain(pedidoUpdate);
		if (!errors.isEmpty()) {
			throw new PedidoDomainException(errors);
		}
		
		pedidoUpdate.setPe_precio(pedido.getPe_precio());
		pedidoUpdate.setPe_cantidad(pedido.getPe_cantidad());
		pedidoUpdate.setPe_formapago(pedido.getPe_formapago());
		pedidoUpdate.setPe_estado(pedido.getPe_estado());
		pedidoUpdate.setPe_plato(pedido.getPe_plato());
		return pedidoDao.save(pedidoUpdate);
	}

	/**
	 * Eliminar pedido por su id
	 * 
	 * @param id identificador del pedido a eliminar
	 */
	@Override
	@Transactional
	public void delete(Long pe_id) throws ResourceNotFoundException{
		Pedido pedido = this.pedidoDao.findById(pe_id).orElse(null);
		if (pedido==null) {
			throw new ResourceNotFoundException();
		}
		pedidoDao.deleteById(pedido.getPe_id());
	}

	/**
	 * Valida las reglas del dominio para las operaciones requeridas.
	 * @param pedido que se desea validar 
	 * @return lista de errores al valdidar
	 */
	private List<PedidoError> validateDomain(Pedido pedido) throws PedidoDomainException{
		List<PedidoError> errors = new ArrayList<>();
		
		if (pedido == null) {
			errors.add(new PedidoError(EnumErrorCodes.NULL, "pedido nulo", "No existe el pedido con ese id"));
		}
		return errors;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> findPedidos(Long rest_id, byte pe_estado) {
		// TODO Auto-generated method stub
		return (List<Pedido>)this.pedidoDao.findPedidos(rest_id, pe_estado);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Pedido> findPedidos(String user_id){
		return (List<Pedido>)this.pedidoDao.findPedidos(user_id);
	}
	
}
