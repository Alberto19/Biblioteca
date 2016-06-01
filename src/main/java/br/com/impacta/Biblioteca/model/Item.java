package br.com.impacta.Biblioteca.model;



import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

	@Id @GeneratedValue
	private long isbn;
	private String titulo;
	private String autor;
	private String editora;
	@Temporal(TemporalType.DATE)
	private Calendar ano;
	private boolean status;
	

	public Item(long isbn, String titulo, String autor, String editora, Calendar ano, boolean status ) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.ano = ano;
		this.status = status;
	}
	

	public Item() {}
	
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

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public Calendar getAno() {
		return ano;
	}

	public void setAno(Calendar ano) {
		this.ano = ano;
	}
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
