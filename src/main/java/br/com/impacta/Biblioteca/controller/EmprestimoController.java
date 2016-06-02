package br.com.impacta.Biblioteca.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.impacta.Biblioteca.dao.EmprestimoDAO;
import br.com.impacta.Biblioteca.model.Emprestimo;

@Controller
public class EmprestimoController {

	private EmprestimoDAO dao;
	private Validator validator;
	private Result result;
	
	@Inject
	public EmprestimoController(EmprestimoDAO dao, Validator validator, Result result) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
	}
	
	public EmprestimoController() {
		this(null,null,null);
	}
	
	@Get
	public void index(){
		
	}
	
	@Post
	public void Salvar(Emprestimo emprestimo){
		
		dao.Salvar(emprestimo);
		result.include("mensagem", "Item adicionado com sucesso!");
		result.redirectTo(this).index();
	}
	
	
	
}
