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
import br.com.impacta.Biblioteca.model.Item;
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
	//Action do Login 
	@Get @Public
	public void login() {
	}
	
	//Action de Autenticacao do ussuario
	@Post @Public
	public void autentica(@Valid String login, String senha) {
		if(login == null){
			validator.add(new I18nMessage("usuario", "usuario.invalido"));
			validator.onErrorUsePageOf(this).login();
		}
		if(senha == null){
			validator.add(new I18nMessage("usuario", "usuario.invalido"));
			validator.onErrorUsePageOf(this).login();
		}
		Usuario usuario = dao.BuscaLogin(login);
		
		if(usuario == null){
			validator.add(new I18nMessage("usuario", "usuario.invalido"));
			validator.onErrorUsePageOf(this).login();
		}
		
		if (!usuario.getLogin()  .equals(login)) {
			validator.add(new I18nMessage("usuario", "usuario.invalido"));
			validator.onErrorUsePageOf(this).login();
		}
		
		if (!usuario.getSenha().equals(senha)) {
			validator.add(new I18nMessage("usuario", "usuario.invalido"));
			validator.onErrorUsePageOf(this).login();
		}
		
			if(usuario.getPerfil().equalsIgnoreCase(Usuario.Perfil.ALUNO.name())){
				usuarioLogado.setUsuario(usuario);
				result.redirectTo(UsuarioController.class).index();
			}
			else if(usuario.getPerfil().equalsIgnoreCase(Usuario.Perfil.PROFESSOR.name())){
				usuarioLogado.setUsuario(usuario);
				result.redirectTo(ItemController.class).form();
			}
			else if(usuario.getPerfil().equalsIgnoreCase(Usuario.Perfil.BIBLIOTECARIO.name())){
				usuarioLogado.setUsuario(usuario);
				result.redirectTo(ItemController.class).index();
			}
			else{
				validator.add(new I18nMessage("usuario", "usuario.invalido"));
				validator.onErrorUsePageOf(this).login();
			}	
	}
	
	//Action da pagina principal
	@Get 
	public void index(){
		
	}
	
	//Action do Form
	@Get 
	public void form() {
		
	}
	
	//Action para Salvar um usuario
	@Post 
	public void Salvar(@Valid Usuario usuario) {
		
		if(usuario.getLogin() == null){
			validator.onErrorForwardTo(this).form();
		}
		dao.Salvar(usuario);
		// redirecionado o adiciona para a View lista
		result.include("mensagem", "Usuario adicionado com sucesso!");
		result.redirectTo(this).form();	
		
	}
	
	
	
	

}
