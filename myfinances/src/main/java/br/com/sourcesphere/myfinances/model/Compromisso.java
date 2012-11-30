package br.com.sourcesphere.myfinances.model;

import java.util.Calendar;

public final class Compromisso 
{
	private Pessoa pessoa;
	private Calendar data;
	private String local;
	private Prioridade prioridade;
	
	public Pessoa getPessoa() 
	{
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa)
	{
		this.pessoa = pessoa;
	}
	
	public Calendar getData() 
	{
		return data;
	}
	
	public void setData(Calendar data) 
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
}
