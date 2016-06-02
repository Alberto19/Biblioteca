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
import br.com.impacta.Biblioteca.dao.ItemDAO;
import br.com.impacta.Biblioteca.model.Item;


@Controller
public class ItemController {

	private ItemDAO dao;
	private final Validator validator;
	private final Result result;
	
	@Inject
	public ItemController(ItemDAO dao, Validator validator, Result result) {
		this.validator = validator;
		this.dao = dao;
		this.result = result;
	}
	public ItemController() {
		this(null,null,null);
	}
	
	@Get 
	public void form() {
		
	}
	
	@Get
	public void index(){
		result.include("itemList", dao.Lista());
	}
	
	@Post 
	public void Salvar(@Valid Item item) {
		if(item.getTitulo() == null){
			validator.onErrorForwardTo(this).form();
		}else if(item.getAutor() == null){
			validator.onErrorForwardTo(this).form();	
		}else if(item.getEditora() == null){
			validator.onErrorForwardTo(this).form();
		}else if(item.getAno() == null){
			validator.onErrorForwardTo(this).form();
		}else if(item.getQuantidade() == 0){
			validator.onErrorForwardTo(this).form();
		}else{
			dao.Salvar(item);
			// redirecionado o adiciona para a View lista
			result.include("mensagem", "Item adicionado com sucesso!");
			result.redirectTo(this).form();
		}
		
	}
	
	
	
	
}
