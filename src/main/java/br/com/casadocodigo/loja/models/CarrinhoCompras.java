/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Gustavo
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras implements Serializable {
    
    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();
    
    public Collection<CarrinhoItem> getItens() {
        return itens.keySet();
    }
    
    public void add(CarrinhoItem item) {
        itens.put(item, getQuantidade(item) + 1);
    }
    
    public int getQuantidade() {
        //return itens.values().size();
        return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }
    
    public Integer getQuantidade(CarrinhoItem item) {
        if (!itens.containsKey(item)){
            itens.put(item, 0);
        }
        
        return itens.get(item);
    }
    
    public BigDecimal getTotal(CarrinhoItem item) {
        return item.getTotal(getQuantidade(item));
    }
    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        
        for (CarrinhoItem item : itens.keySet()) {
            total = total.add(getTotal(item));
        }
        return total;
    }
    
    public void remover(Integer produtoId, TipoPreco tipoPreco) {
        Produto produto = new Produto();
        produto.setId(produtoId);
        
        this.itens.remove(new CarrinhoItem(produto, tipoPreco));
    }
    
}
