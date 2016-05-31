package br.com.impacta.Biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	public enum Perfil{
		ALUNO, PROFESSOR, BIBLIOTECARIO;
	}
	
	@Id
	@GeneratedValue
	private long id;
	private String login;
	private String senha;
	private String perfil;


	public Usuario(String login, String senha, String perfil) {
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}
	
	public Usuario() {}
	
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
