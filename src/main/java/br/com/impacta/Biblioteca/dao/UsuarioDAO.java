package br.com.impacta.Biblioteca.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.impacta.Biblioteca.model.Usuario;


public class UsuarioDAO {

private final EntityManager em;
	
	@Inject
	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}
	
	@Deprecated
	public UsuarioDAO() {
		this(null); // para uso do CDI
	}
	//Metodo para Salvar Usuario
	public void Salvar(Usuario usuario) {
		em.persist(usuario);
	}	
	//Metodo para Remover Usuario
	public void Remover(Usuario usuario) {
		em.remove(Buscar(usuario));
	}
	//Metodo para Buscar Usuario
	public Usuario Buscar(Usuario usuario) {
		return em.find(Usuario.class, usuario.getId());
	}
	
	public Usuario BuscaLogin(String login) {
	
		try{
			return em.createQuery("select u from Usuario u where u.login = "
					+ ":login", Usuario.class)
					.setParameter("login", login)
					.getSingleResult();
		}catch(NoResultException ex){
			return null ;
		}
		
	}
	
	
	/*
	//Metodo Para Verificar se um Usuario Existe
	public boolean existe(Usuario usuario) {
		return !em.createQuery("select u from Usuario u where u.login = "
			+ ":login and u.senha = :senha and u.perfil = :perfil" , Usuario.class)
			.setParameter("login", usuario.getLogin())
			.setParameter("senha", usuario.getSenha())
			.setParameter("perfil", usuario.getPerfil())
			.getResultList().isEmpty();
	}*/
	
	
	/*public boolean existe(Usuario usuario) {
		return em.createQuery("select u from Usuario u where u.login = "
			+ ":login, Usuario.class)
			.setParameter("login", usuario.getLogin())
			.getResultList().isEmpty();
	}*/
	
	
	
}
