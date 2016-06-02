
package br.com.impacta.Biblioteca.dao;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.impacta.Biblioteca.model.Item;

public class ItemDAO {
	
	private EntityManager em;
	
	@Inject
	public ItemDAO(EntityManager em) {
		this.em = em;
	}
	
	public ItemDAO() {
		this(null);
	}
	
	//metodo para Salvar um livro
	public void Salvar(Item item) {
		em.persist(item);
	}
	//Metodo para Remover um livro
	public void Remover(Item item) {
		em.remove(item);
	}
	//Metodo para Buscar um livro
	public Item Buscar(Item item){
		return em.find(Item.class, item.getIsbn());
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> Lista() {
		return em.createQuery("select i from Item i").getResultList();
	}
}
