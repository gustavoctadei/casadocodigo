/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gustavo
 */
@Controller
public class ProdutosController {
    
    @Autowired
    private ProdutoDAO produtoDao;
    
    @RequestMapping("produtos/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        
        return modelAndView;
    }
    
    @RequestMapping("produtos")
    public String gravar(Produto produto) {
        System.out.println(produto);
        produtoDao.gravar(produto);
        
        return "produtos/ok";
    }
    
}
