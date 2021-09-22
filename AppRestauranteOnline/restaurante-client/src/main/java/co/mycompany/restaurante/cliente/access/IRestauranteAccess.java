package co.mycompany.restaurante.cliente.access;

import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.domain.entity.DiaSemana;
import co.mycompany.restaurante.cliente.domain.entity.Pedido;
import co.mycompany.restaurante.cliente.domain.entity.Plato;
import co.mycompany.restaurante.cliente.domain.entity.Restaurante;
import co.mycompany.restaurante.cliente.domain.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Kevith Felipe Bastidas
 */
public interface IRestauranteAccess {

    /**
     * Adiciona un componenete a la base de datos
     * @param componente
     * @return
     */
    public String addComponente(Componente componente);
    /**
     * Elimina un componente de la base de datos.
     * @param idComponente
     * @return 
     */
    public String deleteComponente(int idComponente);
    /**
     * obtiene todos los componentes registrados
     * @return 
     */
    public ArrayList<Componente> getComponentes();
    /**
     * obtiene un componente de un id determinado.
     * @param idComponente
     * @return 
     */
    public Componente getComponente(int idComponente);
    /**
     * Obtiene el menu de los componenetes en un restaurante y dia determinado
     * @param idRestaurante
     * @param dia
     * @return 
     */
    public ArrayList<Componente> getMenuComponentes(int idRestaurante,DiaSemana dia);
    /**
     * Adiciona un componente en un restuarante determinado y dia determinado
     * @param idRestaurante
     * @param componente
     * @param dia
     * @return
     */
    public String addComponenteSemanal(int idRestaurante,Componente componente,DiaSemana dia);
    /**
     * Elimina un componente de un restaurante determinado en un dia determinado
     * @param idRestaurante
     * @param componente
     * @param dia
     * @return
     */
    public String deleteComponenteSemanal(int idRestaurante,Componente componente,DiaSemana dia);
    /**
     * Actualiza el plato en un restaurante determinado
     * @param idRestaurante
     * @param dia
     * @param plato
     * @return 
     */
    public String updatePlato(int idRestaurante,DiaSemana dia,Plato plato); 
    /**
     * obtiene la lista de todos los restaurantes pertenecientes aun administrador
     * @param user_id
     * @return 
     */
    public List<Restaurante> getRestaurantes(String user_id);
    /**
     * obtiene la lista de todos los restaurantes
     * @return 
     */
    public List<Restaurante> getRestaurantes();
    /**
     * obtiene un resturante buscado por el id
     * @param idRestaurante
     * @return 
     */
    public Restaurante getRestaurante(int idRestaurante);
    /**
     * Elimina la informacion  de un restaurante
     * @param idRestaurante
     * @return 
     */
    public String deleteRestaurante(int idRestaurante);
    /**
     * Adiciona la informacion de un restaurante.
     * @param restaurante
     * @return 
     */
    public String addRestaurante(Restaurante restaurante);
    /**
     * Elimina la informacion del plato de un restaurante en un dia determinado.
     * @param idRestaurante
     * @param dia
     * @return 
     */
    public String deletePlato(int idRestaurante, DiaSemana dia);
    
    /**
     * obtiene el plato del un restaurante con id
     * @param idRestaurante
     * @param dia
     * @return 
     */
    public Plato getPlato(int idRestaurante, DiaSemana dia);
    /**
     * Adiciona la informacion del plato de un restaurante en un dia determinado.
     * @param plato
     * @return 
     */
    public String addPlato(Plato plato);
    /**
     * obtiene la clave del administrador en caso de existir
     * @param usuario
     * @return 
     */
    public Usuario getUsuario(String usuario);
    /**
     * obtiene los pedidos de un restaurante y estado determinado
     * @param idRestaurante
     * @param estado
     * @return 
     */
    public List<Pedido> getPedidos(int idRestaurante,int estado);
    /**
     * obtiene los pedidos de un usuario determinado
     * @param user
     * @return 
     */
    public List<Pedido> getPedidos(String user);
    
    /**
     * Adiciona la informacion de los pedidos de un restaurante en un dia determinado.
     * @param pedido
     * @return 
     */
    public String addPedido(Pedido pedido);
    /**
     * Elimina el pedido de un usuario
     * @param pe_id
     * @return 
     */
    public String deletePedido(int pe_id);
    /**
     * Actualiza el pedido de un usuario determinado
     * @param pe_id
     * @param pedido
     * @return 
     */
    public String updatePedido(int pe_id,Pedido pedido);
}
