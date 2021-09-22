/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.restaurante.cliente.access.adapter;

import co.mycompany.restaurante.cliente.domain.entity.Componente;
import co.mycompany.restaurante.cliente.domain.entity.TipoComponente;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevit
 */
public class RestauranteAccessImplJsonJersey implements IRestauranteAccessJsonJersey{

    /**
     * Lista de comidas
     */
    private List<String> componentes;
    
    private List<Componente> lista;
    /**
     * Constructor
     */
    public RestauranteAccessImplJsonJersey(){
        lista = new ArrayList<>();
        lista.add(new Componente(2, "frijoles", TipoComponente.PRINCIPIO));
        lista.add(new Componente(6, "sancocho de gallina", TipoComponente.ENTRADA));
        lista.add(new Componente(11, "chuleta de cerdo", TipoComponente.PROTEINA));
        lista.add(new Componente(15, "limonada", TipoComponente.BEBIDA));
        if(componentes == null){
            componentes = new ArrayList<>();
            InicializarPlatos();
        }
    }
    /**
     * inicializamos algunas comidas
     */
    private void InicializarPlatos() {
        componentes.add(convertToJson(new Componente(1, "frijoles", TipoComponente.PRINCIPIO)));
        componentes.add(convertToJson(new Componente(2, "jugo hit", TipoComponente.BEBIDA)));
        componentes.add(convertToJson(new Componente(3, "sopa de verduras", TipoComponente.ENTRADA)));
        componentes.add(convertToJson(new Componente(4, "chuleta de pollo", TipoComponente.PROTEINA)));
    }
    
    
    
    public String listaComponentes(){
        Gson gson = new Gson();
        String json = gson.toJson(this.lista);
        return json;
    }
    
    public List<Componente> listaComponentes2(String jsonLista){
        Gson gson = new Gson();
        List<Componente> listaConvertida = new ArrayList<>();
        
        // Obtain Array
        JsonParser parser = new JsonParser();

        // Obtain Array
        JsonArray gsonArr = parser.parse(jsonLista).getAsJsonArray();
        
        for (JsonElement obj : gsonArr) {
            String jsonComponente = obj.toString();
            Componente comp = gson.fromJson(jsonComponente, Componente.class);
            listaConvertida.add(comp);
            
        }
        return listaConvertida;
    }
    
    /**
     * Función que convierte un objeto a un formato json 
     * @param food objeto
     * @return String en formato Json
     */
    private String convertToJson(Componente componente) {
        Gson gson = new Gson();
        String json = gson.toJson(componente);
        return json;
    }
    
    
    
    /**
     * Función que convierte un string en formato json a un objeto
     * @param jsonFood String en formato json
     * @return un objeto de tipo Food
     */
    private Componente jsonToFood(String jsonComponente){
        Gson gson = new Gson();
        Componente comp = gson.fromJson(jsonComponente, Componente.class);
        return comp;
    }
    
    @Override
    public List<String> getComponentes() {
        return this.componentes;
    }

    @Override
    public Componente getComponente(int comp_id){
        int i;
        Componente result =null;
        for(i=0;i<componentes.size();i++){
            String a =componentes.get(i);
            if(a.contains("\"id\":"+comp_id+",")){
                result=jsonToFood(componentes.get(i));
            }  
        }
        return result;
    }
    
    @Override
    public boolean addComponente(Componente componente) {
        if (getComponente(componente.getId())==null) {
            this.componentes.add(convertToJson(componente));
            return true;
        }
        return false;
    }

    @Override
    public boolean modify(Componente componente) {
        if (getComponente(componente.getId()) != null) {
            for (int i = 0; i < componentes.size(); i++) {
                String a = componentes.get(i);
                if (a.contains("\"id\":" + componente.getId() + ",")) {
                    componentes.remove(i);
                    componentes.add(i, convertToJson(componente));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void remove(int id) {
        Componente componente = getComponente(id);
        if (componente != null) {
            for (int i = 0; i < componentes.size(); i++) {
                String a = componentes.get(i);
                if (a.contains("\"id\":" + componente.getId() + ",")) {
                    componentes.remove(i);
                }
            }
        }
    }
    
}
