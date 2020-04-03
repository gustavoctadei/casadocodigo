/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.daos.UsuarioDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gustavo
 */
@Controller
public class HomeController {
    
    @Autowired
    private ProdutoDAO produtoDao;
    
    @Autowired
    private UsuarioDAO usuarioDao;
    
    @RequestMapping(name = "index", value = "/")
    @Cacheable(value = "produtosHome")
    public ModelAndView index(){
        List<Produto> produtos = produtoDao.listar();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos", produtos);
        
        return modelAndView;
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/url-magica-maluca-r4t7832937hldjkfb9e03r934i9f9rfjpqçemd0p24j8fr03fhiec")
    public String urlMagicaMaluca() {
        Usuario usuario = new Usuario();
        usuario.setNome("Admin");
        usuario.setEmail("admin@casadocodigo.com.br");
        
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        String hashSenha = enc.encode("123456");
        usuario.setSenha(hashSenha);
        usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
        
        usuarioDao.gravar(usuario);
        return "Url magica Executada";
    }
    
}
