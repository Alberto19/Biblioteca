package br.com.impacta.Biblioteca.model;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo  {
	
	@Id @GeneratedValue
	private long id;
	@OneToOne
	private Usuario bibliotecario;
	@OneToOne
	private Usuario solicitante;
	@OneToMany
	private List<Item> itens;
	
	@Temporal(TemporalType.DATE) 
	private Calendar dataEmprestimo;
	
	@Temporal(TemporalType.DATE) 
	private Calendar dataDevolucao;
	

	public Emprestimo(long id, Usuario bibliotecario, Usuario solicitante , List<Item> itens, Calendar dataEmprestimo, Calendar dataDEvolucao) {
		this.id = id;
		this.bibliotecario = bibliotecario;
		this.solicitante = solicitante;
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
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
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
