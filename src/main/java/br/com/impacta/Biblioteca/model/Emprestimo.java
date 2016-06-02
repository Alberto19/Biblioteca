package br.com.impacta.Biblioteca.model;



import java.util.Calendar;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;


@Entity
public class Emprestimo  {
	
	@Id @GeneratedValue
	private long id;
	private Usuario usuario;

	private Item item;
	@Temporal(TemporalType.DATE) @NotNull
	private Calendar data;
	

	public Emprestimo(long id, Usuario usuario, Item item, Calendar data) {
		this.id = id;
		this.usuario = usuario;
		this.item = item;
		this.data = data;	
	}
	public Emprestimo() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
}
