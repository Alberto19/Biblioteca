package br.com.impacta.Biblioteca.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.vraptor.Get;
import br.com.impacta.Biblioteca.model.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class UsuarioLogado implements Serializable{

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
