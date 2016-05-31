package br.com.impacta.Biblioteca.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.impacta.Biblioteca.annotations.Public;
import br.com.impacta.Biblioteca.dao.UsuarioDAO;
import br.com.impacta.Biblioteca.model.Usuario;

@Controller
public class UsuarioController {

	private final UsuarioDAO dao;
	private final Validator validator;
	private final Result result;
	private final UsuarioLogado usuarioLogado;

	@Inject
	public UsuarioController(UsuarioDAO dao, Validator validator, Result result, UsuarioLogado usuarioLogado) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}

	public UsuarioController() {
		this(null, null, null, null);
	}

	@Get @Public
	public void form() {
	}
	@Get 
	public void index(){
		
	}
	

	@Post @Public
	public void autentica(@Valid String login, String senha, String perfil) {
		if(login == null){
			validator.add(new I18nMessage("usuario", "usuario.invalido"));
			validator.onErrorUsePageOf(this).form();
		}
		Usuario usuario = dao.BuscaLogin(login);
		
		
		if (!usuario.getLogin().equals(login)) {
			validator.add(new I18nMessage("usuario", "usuario.invalido"));
			validator.onErrorUsePageOf(this).form();
		}
		
		if (!usuario.getSenha().equals(senha)) {
			validator.add(new I18nMessage("usuario", "usuario.invalido"));
			validator.onErrorUsePageOf(this).form();
		}
		
		if(perfil.equalsIgnoreCase(usuario.getPerfil())){
			if(usuario.getPerfil().equalsIgnoreCase(Usuario.Perfil.ALUNO.name())){
				usuarioLogado.setUsuario(usuario);
				result.redirectTo(UsuarioController.class).index();
			}
			if(perfil.equalsIgnoreCase(Usuario.Perfil.PROFESSOR.name())){
				usuarioLogado.setUsuario(usuario);
				result.redirectTo(ItemController.class).form();
			}
			if(perfil.equalsIgnoreCase(Usuario.Perfil.BIBLIOTECARIO.name())){
				usuarioLogado.setUsuario(usuario);
				result.redirectTo(ItemController.class).lista();
			}
		}else{
			validator.add(new I18nMessage("usuario", "usuario.invalido"));
			validator.onErrorUsePageOf(this).form();
		}	
		
	}
	
	/*
	@Post 
	public void  autentica(@Valid Usuario usuario) {
		
		if(!dao.existe(usuario)){
			validator.add(new I18nMessage("login", "login.invalido"));
			validator.onErrorUsePageOf(this).form();
		}
		usuarioLogado.setUsuario(usuario);
		result.redirectTo(UsuarioController.class).index();
		
	}*/
}
