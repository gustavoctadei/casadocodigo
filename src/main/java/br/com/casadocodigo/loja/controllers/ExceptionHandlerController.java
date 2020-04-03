/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gustavo
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ModelAndView trataExceptionGenerica(Exception ex) {
        System.out.println("Exceção Acontecendo");
        ex.printStackTrace();
        
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", ex);
        
        return modelAndView;
    }

}
