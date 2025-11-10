package com.sandro.agendadortarefas.infrastructure.security.client;

import com.sandro.agendadortarefas.business.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

//name pode ser qualquer nome, não deixar a url como "suaurlaqui" porque quando voce precisar trocar a url ou algo assim voce tera que derrubar o servidor para poder mudar a url no codigo
@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);
}
