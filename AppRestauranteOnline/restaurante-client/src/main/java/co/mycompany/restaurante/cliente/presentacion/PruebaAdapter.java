package co.mycompany.restaurante.cliente.presentacion;

import co.mycompany.restaurante.cliente.access.adapter.IRestauranteAccessJsonJersey;
import co.mycompany.restaurante.cliente.access.adapter.RestauranteAccessImplJsonJersey;
import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.domain.entity.TipoComponente;

/**
 *
 * @author kevith Felipe Bastidas
 */
public class PruebaAdapter {

    public static void main(String[] args) {
        IRestauranteAccessJsonJersey repo = new RestauranteAccessImplJsonJersey();
        for (String c : repo.getComponentes()) {
            System.out.println(c);
        }
        
        System.out.println("----------------");
        repo.modify(new Componente(5, "prueba", TipoComponente.PROTEINA));
        for (String c : repo.getComponentes()) {
            System.out.println(c);
        }
        System.out.println("----------------");
        Componente c=repo.getComponente(3);
        System.out.println(c);
        
        
    }
    
}
