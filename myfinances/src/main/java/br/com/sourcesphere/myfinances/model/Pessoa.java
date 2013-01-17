package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Classe que representa a entidade Pessoa
 * @author Guilherme Dio
 * @since 1.0
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa
{
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE) 
	@Column(nullable=false)
	private Long id;
	private String nome;
	@OneToOne @Cascade(value={CascadeType.ALL})
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
