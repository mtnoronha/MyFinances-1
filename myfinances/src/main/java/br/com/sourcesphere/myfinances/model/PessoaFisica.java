package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public final class PessoaFisica extends Pessoa 
{
//	@Id 
//	@GeneratedValue(strategy=GenerationType.IDENTITY) 
//	@Column(nullable=false)
//	private Long id;
	@Column(length=10)
	private String rg;
	@Column(length=11)
	private String cpf;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataNascimento;
	
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
