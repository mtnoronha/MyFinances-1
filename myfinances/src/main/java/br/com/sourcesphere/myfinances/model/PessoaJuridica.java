package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe que representa a entidade PessoaJuridica
 * @see Pessoa
 * @author Guilherme Dio
 * @since 1.0
 */
@Entity
public final class PessoaJuridica extends Pessoa 
{
	@Column(length=14)
	private String cnpj;
	private String site;
	
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
