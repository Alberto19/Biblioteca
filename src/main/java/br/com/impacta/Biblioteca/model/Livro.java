package br.com.impacta.Biblioteca.model;

import java.util.Calendar;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.caelum.vraptor.Convert;

@Entity
public class Livro {

	@Id @GeneratedValue
	private long isbn;


	private String titulo;
	private String autor;
	
	@Convert(Calendar.class)
	private Calendar ano;
	
	@Inject
	public Livro(long isbn, String titulo, String autor, Calendar ano ) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}
	
	@Deprecated
	public Livro() {
	
	}
	
	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Calendar getAno() {
		return ano;
	}

	public void setAno(Calendar ano) {
		this.ano = ano;
	}

}
