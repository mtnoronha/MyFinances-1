package br.com.sourcesphere.myfinances.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria 
{
	@Id @GeneratedValue
	private Long id;
	private String descricao;
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	public Long getId() 
	{
		return id;
	}
	
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	
	@Override
	public String toString() 
	{
		return "Categoria de "+descricao;
	}
}
