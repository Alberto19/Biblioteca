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

	private UsuarioDAO dao;
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
	@Get @Public
	public void index(){
		
	}
	

	@Post @Public
	public void autentica(@Valid Usuario usuario) {

		if (!dao.existe(usuario)) {
			validator.onErrorUsePageOf(this).form();
		}
		usuarioLogado.setUsuario(usuario);
		result.redirectTo(UsuarioController.class).index();
	}

}
