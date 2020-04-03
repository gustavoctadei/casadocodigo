/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import javax.persistence.Embeddable;

/**
 *
 * @author Gustavo
 */
@Embeddable
public class Preco {
    
    private BigDecimal valor;
    private TipoPreco tipo;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo.name() + " - " + this.valor;
    }
    
}
