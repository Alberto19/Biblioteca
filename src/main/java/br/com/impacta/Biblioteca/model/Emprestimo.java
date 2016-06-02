package br.com.impacta.Biblioteca.model;



import java.util.Calendar;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;





@Entity
public class Emprestimo  {
	
	@Id @GeneratedValue
	private long id;
	@OneToOne
	private Usuario bibliotecario;
	@OneToOne
	private Usuario tomador;
	@OneToMany
	private List<Item> itens;
	
	@Temporal(TemporalType.DATE) @NotNull
	private Calendar dataEmprestimo;
	
	@Temporal(TemporalType.DATE) @NotNull
	private Calendar dataDevolucao;
	

	public Emprestimo(long id, Usuario bibliotecario, Usuario tomador , List<Item> itens, Calendar dataEmprestimo, Calendar dataDEvolucao) {
		this.id = id;
		this.bibliotecario = bibliotecario;
		this.tomador = tomador;
		this.itens = itens;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDEvolucao;
	
	}
	public Emprestimo() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Usuario getBibliotecario() {
		return bibliotecario;
	}
	public void setBibliotecario(Usuario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}
	public Usuario getTomador() {
		return tomador;
	}
	public void setTomador(Usuario tomador) {
		this.tomador = tomador;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}


	
}
