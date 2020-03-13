/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Gustavo
 */

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {
    
    @Autowired
    private CarrinhoCompras carrinho;
    
    @RequestMapping(name = "finalizarCarrinho", method = RequestMethod.POST)
    public ModelAndView finalizar(RedirectAttributes model) {
        System.out.println(carrinho.getTotal());
        
        model.addFlashAttribute("sucesso", "Pagamento realizado com sucesso.");
        
        return new ModelAndView("redirect:/produtos");
    }
    
}
