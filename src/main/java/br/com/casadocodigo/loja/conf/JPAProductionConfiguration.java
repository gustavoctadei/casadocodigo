/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.conf;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Gustavo
 */

@Profile("prod")
public class JPAProductionConfiguration {
    
    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        
        //usuario:senha@host:port/path
        URI dbUrl = new URI(environment.getProperty("DATABASE_URL"));
        
        String url = "jdbc:postgresql://" + dbUrl.getHost() + ":" + dbUrl.getPort() + dbUrl.getPath();
        dataSource.setUrl(url);
        dataSource.setUsername(dbUrl.getUserInfo().split(":")[0]);
        dataSource.setPassword(dbUrl.getUserInfo().split(":")[1]);

        return dataSource;
    }

    @Bean
    private Properties additionalProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");

        return props;
    }

}