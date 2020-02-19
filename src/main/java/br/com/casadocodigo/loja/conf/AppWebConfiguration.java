/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.conf;

import br.com.casadocodigo.loja.controllers.HomeController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Gustavo
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class})
public class AppWebConfiguration {
    
}
