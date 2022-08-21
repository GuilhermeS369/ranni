package com.ranni.services;

import com.ranni.entities.User;
import com.ranni.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SecurityDatabaseService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //BUSCA O USUARIO NO BANCO
        User userEntity = userRepository.findByUsername(username);
        //TESTA PARA VER SE É NULO
        if (userEntity == null){
            throw new UsernameNotFoundException(username);
        }
        //LISTA DE AUTORIDADE
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        //PARA CADA UM, ADICIONE NA LISTA
        userEntity.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority("ROLE_"+ role));
        });
        //CRIE UM NOVO USERDETAIL COM NOME, SENHA E AUTORIDADES.
        UserDetails user = new org.springframework.security.core.userdetails.User(userEntity.getUsername(),
                userEntity.getPassword(),
                authorities);
        return user;

    }
}
