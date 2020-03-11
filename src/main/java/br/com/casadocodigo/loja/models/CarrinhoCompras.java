/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.models;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Gustavo
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras {
    
    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();
    
    public void add(CarrinhoItem item) {
        itens.put(item, getQuantidade(item) + 1);
    }
    
    public int getQuantidade() {
        //return itens.values().size();
        return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }
    
    private int getQuantidade(CarrinhoItem item) {
        if (!itens.containsKey(item)){
            itens.put(item, 0);
        }
        
        return itens.get(item);
    }
    
}
