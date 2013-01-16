package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class PessoaJuridica extends Pessoa 
{
//	@Id 
//	@GeneratedValue(strategy=GenerationType.IDENTITY) 
//	@Column(nullable=false)
//	private Long id;
	@Column(length=14)
	private String cnpj;
	private String site;
	
//	@Override
//	public void setId(Long id) 
//	{
//		this.id = id;
//	}
//	@Override
//	public Long getId() 
//	{
//		return this.id;
//	}
	public String getCnpj() 
	{
		return cnpj;
	}
	public void setCnpj(String cnpj) 
	{
		this.cnpj = cnpj;
	}
	public String getSite() 
	{
		return site;
	}
	public void setSite(String site)
	{
		this.site = site;
	}
}
