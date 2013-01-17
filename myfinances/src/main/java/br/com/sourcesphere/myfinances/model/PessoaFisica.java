package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Classe que representa a entidade PessoaFisica
 * @see Pessoa
 * @author Guilherme Dio
 * @since 1.0
 */
@Entity
public final class PessoaFisica extends Pessoa 
{
	@Column(length=10)
	private String rg;
	@Column(length=11)
	private String cpf;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataNascimento;
	
	public String getRg() 
	{
		return rg;
	}
	public void setRg(String rg)
	{
		this.rg = rg;
	}
	public String getCpf() 
	{
		return cpf;
	}
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}
	public void setDataNascimento(DateTime dataNascimento) 
	{
		this.dataNascimento = dataNascimento;
	}
	public DateTime getDataNascimento() 
	{
		return dataNascimento;
	}
}
