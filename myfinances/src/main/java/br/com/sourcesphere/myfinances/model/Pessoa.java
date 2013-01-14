package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class Pessoa
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(nullable=false)
	private Long id;
	private String nome;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataNascimento;
	@Column(length=10)
	private String rg;
	@Column(length=11)
	private String cpf;
	@Column(length=14)
	private String cnpj;
	@OneToOne
	@Cascade(value={CascadeType.ALL})
	private Endereco endereco;
	private String telefone;
	private String celular;
	private String email;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public DateTime getDataNascimento()
	{
		return dataNascimento;
	}
	public void setDataNascimento(DateTime dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}
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
	public Endereco getEndereco()
	{
		return endereco;
	}
	public void setEndereco(Endereco endereco) 
	{
		this.endereco = endereco;
	}
	public String getTelefone() 
	{
		return telefone;
	}
	public void setTelefone(String telefone) 
	{
		this.telefone = telefone;
	}
	public String getCelular() 
	{
		return celular;
	}
	public void setCelular(String celular)
	{
		this.celular = celular;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
}
