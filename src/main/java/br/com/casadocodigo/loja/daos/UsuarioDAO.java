/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gustavo
 */

@Repository
public class UsuarioDAO implements UserDetailsService {
    
    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public Usuario loadUserByUsername(String email) {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
                .setParameter("email", email)
                .getResultList();
        
        if (usuarios.isEmpty()) {
            throw new UsernameNotFoundException("Usuário " + email + "não foi encontrado");
        }
        
        return usuarios.get(0);
    }
    
}
