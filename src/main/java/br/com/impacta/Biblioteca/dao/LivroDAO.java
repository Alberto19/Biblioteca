package br.com.impacta.Biblioteca.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.impacta.Biblioteca.model.Livro;

public class LivroDAO {
	
	private EntityManager em;
	
	@Inject
	public LivroDAO(EntityManager em) {
		this.em = em;
	}
	
	public LivroDAO() {
		this(null);
	}
	
	//metodo para Salvar um livro
	public void Salvar(Livro livro) {
		em.persist(livro);
	}
	//Metodo para Remover um livro
	public void Remover(Livro livro) {
		em.remove(livro);
	}
	//Metodo para Buscar um livro
	public Livro Buscar(Livro livro){
		return em.find(Livro.class, livro.getIsbn());
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> Lista() {
		return em.createQuery("select l from Livro l").getResultList();
	}

}
