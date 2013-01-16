package br.com.sourcesphere.myfinances.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public final class Recurso 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE) 
	@Column(nullable=false)
	private Long id;
	@OneToMany
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	@OneToMany
	private List<Compromisso> compromissos = new ArrayList<Compromisso>();
	
	public List<Lancamento> getLancamentos() 
	{
		return lancamentos;
	}
	public void setLancamentos(List<Lancamento> lancamentos) 
	{
		this.lancamentos = lancamentos;
	}
	public List<Compromisso> getCompromissos()
	{
		return compromissos;
	}
	public void setCompromissos(List<Compromisso> compromissos) 
	{
		this.compromissos = compromissos;
	}
}
