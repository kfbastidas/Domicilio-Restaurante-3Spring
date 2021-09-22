package co.mycompany.restaurante.cliente.presentacion;

import co.mycompany.restaurante.cliente.access.Factory;
import co.mycompany.restaurante.cliente.access.IRestauranteAccess;
import co.mycompany.restaurante.cliente.access.adapter.IRestauranteAccessJsonJersey;
import co.mycompany.restaurante.cliente.access.adapter.RestauranteAccessImplJsonJersey;
import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.domain.entity.Pedido;
import co.mycompany.restaurante.cliente.domain.entity.TipoComponente;
import java.util.List;

/**
 *
 * @author kevith Felipe Bastidas
 */
public class PruebaAdapter {

    public static void main(String[] args) {
        IRestauranteAccess repo = Factory.getInstance().getRestauranteService();
        List<Pedido> lista = repo.getPedidos(1, 0);
        for (Pedido pedido : lista) {
            System.out.println(pedido);
        }
        
        
        /*
        RestauranteAccessImplJsonJersey repo = new RestauranteAccessImplJsonJersey();
        String lista = repo.listaComponentes();
        System.out.println(lista);
        List<Componente> listaConvertida = repo.listaComponentes2(lista);
        System.out.println("-----------------------------------");
        System.out.println(listaConvertida);
        */
    }
    
}
