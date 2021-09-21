package co.mycompany.usuario.access.dao;

import org.springframework.data.repository.CrudRepository;

import co.mycompany.usuario.domain.entity.Usuario;
/**
 * Interfaz DAO de Usuario que extiende CrudRepository
 * @author Kevith Felipe Bastidas
 */

public interface IUsuarioDao extends CrudRepository<Usuario, String> {

}