package br.com.impacta.Biblioteca.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.impacta.Biblioteca.dao.EmprestimoDAO;
import br.com.impacta.Biblioteca.dao.ItemDAO;
import br.com.impacta.Biblioteca.dao.DevolucaoDAO;
import br.com.impacta.Biblioteca.model.Emprestimo;
import br.com.impacta.Biblioteca.model.Usuario;

@Controller
public class EmprestimoController {

	private EmprestimoDAO dao;
	private Validator validator;
	private Result result;
	private ItemDAO itemDao;
	private DevolucaoDAO DevolucaoDAO;
	
	
	@Inject
	public EmprestimoController(EmprestimoDAO dao,ItemDAO itemDao , Validator validator, Result result) {
		this.dao = dao;
		this.itemDao = itemDao;
		this.validator = validator;
		this.result = result;
	}
	
	public EmprestimoController() {
		this(null,null,null,null);
	}
	
	@Get
	public void index(){
		
	}
	@Get
	public void form(){
		result.include("itemList", itemDao.Lista());
	}

	@Get
	public void pedidos(){
		result.include("emprestimoList", dao.Lista());
	}
	@Get
	public Emprestimo edita(Long id) {
		  return dao.BuscaPedido(id);
	}
	@Post
	public void altera(Emprestimo emprestimo){
		dao.Update(emprestimo);
		dao.Remover(emprestimo);
		result.redirectTo(this).pedidos();
	}
	@Post
	public void Salvar(Emprestimo emprestimo){
		dao.Salvar(emprestimo);
		result.include("mensagem", "Item adicionado com sucesso!");
		result.redirectTo(this).index();
	}
	
	
	
}
