package dataFactory;

import pojo.UsuarioPojo;

public class UsuarioDataFactory {

    public static UsuarioPojo loginUsuarioAdministrador(){
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setUsuarioLogin("admin");
        usuario.setUsuarioSenha("admin");

        return usuario;
    }

    public static UsuarioPojo loginUsuarioPadrao(){
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setUsuarioLogin("mhbianchi");
        usuario.setUsuarioSenha("123456");
        return usuario;
    }

    public static UsuarioPojo criarNovoUsuario(String nome, String login, String senha){
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setUsuarioNome(nome);
        usuario.setUsuarioLogin(login);
        usuario.setUsuarioSenha(senha);
        return usuario;
    }

    public static UsuarioPojo criarNovoUsuarioRepetido() {
        UsuarioPojo usuarioRepetido = new UsuarioPojo();
        usuarioRepetido.setUsuarioNome("Maria Helena");
        usuarioRepetido.setUsuarioLogin("mhbianchi");
        usuarioRepetido.setUsuarioSenha("123456");
        return usuarioRepetido;
    }

}
