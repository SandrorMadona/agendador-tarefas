package com.sandro.agendadortarefas.infrastructure.security;

import com.sandro.agendadortarefas.business.UsuarioDTO;
import com.sandro.agendadortarefas.infrastructure.entity.Usuario;
import com.sandro.agendadortarefas.infrastructure.repository.UsuarioRepository;
import com.sandro.agendadortarefas.infrastructure.security.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl{

    @Autowired
    private UsuarioClient client;

    // Implementação do metodo para carregar detalhes do usuário pelo e-mail
    public UserDetails carregaDadosUsuario(String email, String token){
        UsuarioDTO usuarioDTO = client.buscaUsuarioPorEmail(email, token);
        return User
                .withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
