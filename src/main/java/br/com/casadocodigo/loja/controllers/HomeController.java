/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gustavo
 */
@Controller
public class HomeController {
    
    @Autowired
    private ProdutoDAO produtoDao;
    
    @RequestMapping(name = "index", value = "/")
    @Cacheable(value = "produtosHome")
    public ModelAndView index(){
        List<Produto> produtos = produtoDao.listar();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos", produtos);
        
        return modelAndView;
    }
    
}
