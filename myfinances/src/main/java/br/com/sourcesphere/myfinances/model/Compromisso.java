package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public final class Compromisso 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(nullable=false)
	private Long id;
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Pessoa pessoa;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime data;
	private String local;
	@Enumerated(EnumType.ORDINAL)
	private Prioridade prioridade;
	
	public Pessoa getPessoa() 
	{
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa)
	{
		this.pessoa = pessoa;
	}
	
	public DateTime getData() 
	{
		return data;
	}
	
	public void setData(DateTime data) 
	{
		this.data = data;
	}
	
	public String getLocal() 
	{
		return local;
	}
	
	public void setLocal(String local) 
	{
		this.local = local;
	}
	
	public Prioridade getPrioridade()
	{
		return prioridade;
	}
	
	public void setPrioridade(Prioridade prioridade) 
	{
		this.prioridade = prioridade;
	}

	@Override
	public String toString() 
	{
		return "Compromisso [id=" + id + ", pessoa=" + pessoa + ", data="
				+ data + ", local=" + local + ", prioridade=" + prioridade
				+ "]";
	}
}
