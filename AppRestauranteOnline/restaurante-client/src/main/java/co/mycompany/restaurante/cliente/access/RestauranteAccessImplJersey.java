package co.mycompany.restaurante.cliente.access;

import co.mycompany.restaurante.cliente.domain.entity.*;
import co.mycompany.restaurante.cliente.infra.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevith Felipe Bastidas
 */
public class RestauranteAccessImplJersey implements IRestauranteAccess{
    /**
     * Atributo: instacia la clase ClientServicePlato
     */
    private ClientServicePlato clientPlato;
    /**
     * Atributo: instacia la clase clientComponente;
     */
    private ClientServiceComponente clientComponente;
    /**
     * Atributo: instancia la clase clientComponente
     */
    private ClientServiceRestaurante clientResturante;
    /**
     * Atributo: instancia la clase clientRestaurante
     */
    private ClientServiceRestComp clientRestComp;
    /**
     * Atributo: instancia la clase clientUsuario
     */
    private ClientServiceUsuario clientUsuario;
    /**
     * Atributo: instancia la clase ClientPedido
     */
    private ClientServicePedido clientPedido;
    /**
     * Contructor por defecto de RestauranteAcessImplJersey
     */
    public RestauranteAccessImplJersey() {
        this.clientPlato = new ClientServicePlato();
        this.clientComponente = new ClientServiceComponente();
        this.clientResturante = new ClientServiceRestaurante();
        this.clientRestComp = new ClientServiceRestComp();
        this.clientUsuario = new ClientServiceUsuario();
        this.clientPedido = new ClientServicePedido();
    }
     /**
     * Adiciona la informacion del plato de un restaurante en un dia determinado.
     * @param plato
     * @return 
     */
    @Override
    public String addPlato(Plato plato){
        return clientPlato.addPlato(plato);
    }
    /**
     * Elimina la informacion del plato de un restaurante en un dia determinado.
     * @param idRestaurante
     * @param dia
     * @return 
     */
    @Override
    public String deletePlato(int idRestaurante, DiaSemana dia){
        return clientPlato.deletePlato(idRestaurante, dia);
    }   
    /**
     * Adiciona un componenete a la base de datos
     * @param componente
     * @return
     */
    @Override
    public String addComponente(Componente componente) {
        return clientComponente.createComponente(componente);
    }
    /**
     * Elimina un componente de la base de datos.
     * @param idComponente
     * @return 
     */
    @Override
    public String deleteComponente(int idComponente){
        return clientComponente.deleteComponente(idComponente);
    }   
    /**
     * obtiene un componente de un id determinado.
     * @param idComponente
     * @return 
     */
    @Override
    public Componente getComponente(int idComponente){
        return clientComponente.getComponente(idComponente);
    }
    /**
     * obtiene todos los componentes registrados
     * @return 
     */
    @Override
    public ArrayList<Componente> getComponentes() {
        ArrayList<Componente> componentes = new ArrayList<>();
        List<Componente> componentes2 = this.clientComponente.findAllComponentes();
        for (Componente componente : componentes2) {
            componentes.add(componente);
        }
        return componentes;
    }
    /**
     * Obtiene el menu de los componenetes en un restaurante y dia determinado
     * @param idRestaurante
     * @param dia
     * @return 
     */
    @Override
    public ArrayList<Componente> getMenuComponentes(int idRestaurante, DiaSemana dia) {
        ArrayList<Componente> componentes = new ArrayList<>();
        List<Integer> Idcomponentes = this.clientRestComp.getMenuComponentes(idRestaurante,dia);    
        for (int comp_id : Idcomponentes) {
            componentes.add(getComponente(comp_id));
        }
        return componentes;
    }
    /**
     * Adiciona un componente en un restuarante determinado y dia determinado
     * @param idRestaurante
     * @param componente
     * @param dia
     * @return
     */
    @Override
    public String addComponenteSemanal(int idRestaurante, Componente componente, DiaSemana dia) {
        return this.clientRestComp.addComponenteSemanal(idRestaurante, componente, dia);
    }
    /**
     * Elimina un componente de un restaurante determinado en un dia determinado
     * @param idRestaurante
     * @param componente
     * @param dia
     * @return
     */
    @Override
    public String deleteComponenteSemanal(int idRestaurante, Componente componente, DiaSemana dia) {
        return this.clientRestComp.deleteComponenteSemanal(idRestaurante, componente.getId(), dia);
    }
    /**
     * Actualiza el plato en un restaurante determinado
     * @param idRestaurante
     * @param dia
     * @param plato
     * @return 
     */
    @Override
    public String updatePlato(int idRestaurante,DiaSemana dia, Plato plato) {
        return clientPlato.updatePlato(idRestaurante, dia, plato);
    }
    /**
     * obtiene la lista de todos los restaurantes pertenecientes aun administrador
     * @param user_id
     * @return 
     */
    @Override
    public List<Restaurante> getRestaurantes(String user_id){
        List<Restaurante> res = clientResturante.findAllRestaurantes(user_id);
        return res;
    }
    /**
     * obtiene la lista de todos los restaurantes
     * @return 
     */
    @Override
    public List<Restaurante> getRestaurantes() {
        List<Restaurante> res = clientResturante.findAllRestaurantes();
        return res;
    }
    /**
     * obtiene un resturante buscado por el id
     * @param idRestaurante
     * @return 
     */
    @Override
    public Restaurante getRestaurante(int idRestaurante){
        return clientResturante.getRestaurante(idRestaurante);
    }    
    /**
     * Elimina la informacion  de un restaurante
     * @param idRestaurante
     * @return 
     */
    @Override
    public String deleteRestaurante(int idRestaurante){
        return clientResturante.deleteRestaurante(idRestaurante);
    }    
    /**
     * Adiciona la informacion de un restaurante.
     * @param restaurante
     * @return 
     */
    @Override
    public String addRestaurante(Restaurante restaurante){
        return clientResturante.addRestaurante(restaurante);
    }
    /**
     * obtiene el plato del un restaurante con id
     * @param idRestaurante
     * @param dia
     * @return 
     */
    @Override
    public Plato getPlato(int idRestaurante,DiaSemana dia) {
        Plato plato = clientPlato.getPlato(idRestaurante, dia);
        if(plato==null){
            plato = new Plato(0, "", 0, 0,"", dia, idRestaurante);
            this.clientPlato.addPlato(plato);
            return getPlato(idRestaurante,dia);
        }
        return plato;
    }
    /**
     * obtiene la clave del administrador en caso de existir
     * @param usuario
     * @return 
     */
    @Override
    public Usuario getUsuario(String usuario) {
        return this.clientUsuario.getUsuario(usuario);
    }
    /**
     * obtiene los pedidos de un restaurante y estado determinado
     * @param idRestaurante
     * @param estado
     * @return 
     */
    @Override
    public List<Pedido> getPedidos(int idRestaurante,int estado){
        return this.clientPedido.getPedidos(idRestaurante, estado);
    }
    /**
     * Adiciona la informacion de los pedidos de un restaurante en un dia determinado.
     * @param pedido
     * @return 
     */
    @Override
    public String addPedido(Pedido pedido){
        return this.clientPedido.addPedido(pedido);
    }
    
    /**
     * obtiene los pedidos de un usuario determinado
     * @param user
     * @return 
     */
    @Override
    public List<Pedido> getPedidos(String user){
        return this.clientPedido.getPedidos(user);
    }
    /**
     * Elimina el pedido de un usuario
     * @param pe_id
     * @return 
     */
    @Override
    public String deletePedido(int pe_id){
        return this.clientPedido.deletePedido(pe_id);
    }
     /**
     * Actualiza el pedido de un usuario determinado
     * @param pe_id
     * @param pedido
     * @return 
     */
    @Override
    public String updatePedido(int pe_id,Pedido pedido){
        return this.clientPedido.updatePedido(pe_id, pedido);
    }
}
