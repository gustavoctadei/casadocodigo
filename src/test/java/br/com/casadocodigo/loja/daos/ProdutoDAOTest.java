///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.casadocodigo.loja.daos;
//
//import br.com.casadocodigo.loja.builders.ProdutoBuilder;
//import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
//import br.com.casadocodigo.loja.conf.JPAConfiguration;
//import br.com.casadocodigo.loja.models.Produto;
//import br.com.casadocodigo.loja.models.TipoPreco;
//import java.math.BigDecimal;
//import java.util.List;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author Gustavo
// */
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {JPAConfiguration.class, ProdutoDAO.class, DataSourceConfigurationTest.class})
//@ActiveProfiles("test")
//public class ProdutoDAOTest {
//    
//    @Autowired
//    private ProdutoDAO produtoDAO;
//    
//    @Test
//    @Transactional
//    public void deveSomarTodosOsPrecosPorTipoLivro() {
//        List<Produto> livrosImpressos = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN).mais(3).buildAll();
//        
//        List<Produto> livrosEbook = ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN).mais(3).buildAll();
//        
//        livrosImpressos.stream().forEach(produtoDAO::gravar);
//        livrosEbook.stream().forEach(produtoDAO::gravar);
//        
//        BigDecimal valor = produtoDAO.somaPrecosPorTipoPreco(TipoPreco.IMPRESSO);
//        
//        Assert.assertEquals(new BigDecimal(40).setScale(2), valor);
//    }
//    
//}