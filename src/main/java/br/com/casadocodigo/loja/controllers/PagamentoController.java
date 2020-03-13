/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.DadosPagamento;
import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
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

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(name = "finalizarCarrinho", method = RequestMethod.POST)
    public Callable<ModelAndView> finalizar(RedirectAttributes model) {
        return () -> {
            String uri = "http://book-payment.herokuapp.com/payment";

            try {
                String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
                System.out.println(response);

                model.addFlashAttribute("sucesso", response);
                return new ModelAndView("redirect:/produtos");
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
                model.addFlashAttribute("falha", "Valor maior que o permitido");
                return new ModelAndView("redirect:/produtos");
            }
        };
    }

}