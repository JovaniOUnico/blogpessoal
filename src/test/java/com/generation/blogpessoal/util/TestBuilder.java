package com.generation.blogpessoal.util;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.model.UsuarioLogin;

public class TestBuilder {

    public static Usuario criarUsuario(Long id, String nome, String email, String senha) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setUsuario(email);
        usuario.setSenha(senha);
        usuario.setFoto("-");
        return usuario;
    }
    
    public static UsuarioLogin criarUsuarioLogin(Long id, String nome, String email, String senha) {
        UsuarioLogin usuario = new UsuarioLogin();
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setUsuario(email);
        usuario.setSenha(senha);
        usuario.setFoto("-");
        return usuario;
    }

    public static Usuario criarUsuarioRoot() {
        return criarUsuario(null, "Root", "root@root.com", "rootroot");
    }
}