package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa a entidade Categoria
 * @author Guilherme Dio
 * @since 1.0
 */
@Entity
public class Categoria 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(nullable=false)
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
}
