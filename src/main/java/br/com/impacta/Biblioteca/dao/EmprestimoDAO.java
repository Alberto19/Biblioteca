package br.com.impacta.Biblioteca.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.impacta.Biblioteca.model.Emprestimo;


public class EmprestimoDAO {

	private EntityManager em;
	
	@Inject
	public EmprestimoDAO(EntityManager em ) {
		this.em = em;
	}
	public EmprestimoDAO() {
		this(null);
	}
	
	//metodo para Salvar um Item
	public void Salvar(Emprestimo emprestimo) {
		em.persist(emprestimo);
	}
	//Metodo para Remover um Item
	public void Remover(Emprestimo emprestimo) {
		em.remove(emprestimo);
	}
	//Metodo para Buscar um Item
	public Emprestimo Buscar(Emprestimo emprestimo){
		return em.find(Emprestimo.class, emprestimo.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Emprestimo> Lista() {
		return em.createQuery("select i from Emprestimo i").getResultList();
	}
	
	public Emprestimo Buscar(long id){
		return em.find(Emprestimo.class, id);
	}

	public Emprestimo Update(Emprestimo emprestimo) {
		return em.merge(emprestimo);
	}

	
}
