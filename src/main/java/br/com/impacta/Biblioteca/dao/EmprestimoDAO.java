package br.com.impacta.Biblioteca.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.impacta.Biblioteca.model.Emprestimo;
import br.com.impacta.Biblioteca.model.Item;
import br.com.impacta.Biblioteca.model.Usuario;


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
	
/*	public Emprestimo BuscaPedido(long id, Usuario solicitante, List<Item> itens ){
		return em.find(Emprestimo.class, id);
	}*/
	
	public Emprestimo BuscaPedido(long  id) {
		
		try{
			return em.createQuery("select e from Emprestimo e where e.id = "
					+ ":id", Emprestimo.class)
					.setParameter("id", id)
					.getSingleResult();
		}catch(NoResultException ex){
			return null ;
		}	
	}
	

	public Emprestimo Update(Emprestimo emprestimo) {
		return em.merge(emprestimo);
	}

	
}
