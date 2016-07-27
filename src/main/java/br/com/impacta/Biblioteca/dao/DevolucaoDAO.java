package br.com.impacta.Biblioteca.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.impacta.Biblioteca.model.Emprestimo;

public class DevolucaoDAO {

private EntityManager em;
	
	@Inject
	public DevolucaoDAO(EntityManager em ) {
		this.em = em;
	}
	public DevolucaoDAO() {
		this(null);
	}
	
	//metodo para Salvar um Item
	public void Salvar(Emprestimo emprestimo) {
		em.persist(emprestimo);
	}
	
	
}
