/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Gustavo
 */
@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    
    @Autowired
    private ProdutoDAO produtoDao;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProdutoValidation());
    }
    
    @RequestMapping("/form")
    public ModelAndView form(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        
        return modelAndView;
    }
    
    @RequestMapping(name = "gravarProduto", method = RequestMethod.POST)
    public ModelAndView gravar(@Valid Produto produto, BindingResult result,RedirectAttributes redirectAttributes) {
        
        if (result.hasErrors()) {
            return form(produto);
        }
        
        produtoDao.gravar(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto Cadastrado com Sucesso");
        
        return new ModelAndView("redirect:produtos");
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Produto> produtos = produtoDao.listar();
        
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);
        
        return modelAndView;
    }
    
}
