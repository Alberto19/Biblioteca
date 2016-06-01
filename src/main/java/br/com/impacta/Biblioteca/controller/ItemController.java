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
	public void lista() {
		result.include("itemList", dao.Lista());
	}
	
	@Get
	public void index(){
		
	}
	
	@Post 
	public void Salvar(@Valid Item item) {
		if(item.getTitulo() == null){
			validator.add(new I18nMessage("item", "itemTitulo.invalido"));	
		}else if(item.getAutor() == null){
			validator.add(new I18nMessage("item", "itemAutor.invalido"));	
		}
		
		validator.onErrorUsePageOf(this).form();
		
		
		
		dao.Salvar(item);
		// redirecionado o adiciona para a View lista
		result.include("mensagem", "Item adicionado com sucesso!");
		result.redirectTo(this).form();
	}
	
	
	
	
}
