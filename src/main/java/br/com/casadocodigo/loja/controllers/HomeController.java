/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gustavo
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String index(){
        //System.out.println("Entrando na Home da Casa da CDC");
        return "home";
    }
    
}
