///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.casadocodigo.loja.conf;
//
//import javax.sql.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Profile;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
///**
// *
// * @author Gustavo
// */
//public class DataSourceConfigurationTest {
//    
//    @Bean
//    @Profile("test")
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:postgresql://192.168.56.105:5432/casadocodigo_test");
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres");
//        
//        return dataSource;
//    }
//    
//}
