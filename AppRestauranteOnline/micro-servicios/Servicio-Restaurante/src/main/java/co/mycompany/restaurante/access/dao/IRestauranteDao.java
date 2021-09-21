package co.mycompany.restaurante.access.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import co.mycompany.restaurante.domain.entity.Restaurante;

/**
 * Interfaz DAO de Restuarante que extiende CrudRepository
 * @author Kevith Felipe Bastidas
 */

public interface IRestauranteDao extends CrudRepository<Restaurante, Long> {
	@Query(value = "Select * from RESTAURANTE r where r.user_id = ?1",nativeQuery = true)
	public List<Restaurante> findByIdUser(String id);
}