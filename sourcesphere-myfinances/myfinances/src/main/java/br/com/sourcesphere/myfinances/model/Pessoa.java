package br.com.sourcesphere.myfinances.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Pessoa
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(nullable=false)
	private Long id;
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataNascimento;
	@Column(length=10)
	private String rg;
	@Column(length=11)
	private String cpf;
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
	public Calendar getDataNascimento()
	{
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento)
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
	
	@Override
	public String toString() 
	{
		return "Pessoa [id=" + id + ", nome=" + nome + ", dataNascimento="
				+ dataNascimento + ", rg=" + rg + ", cpf=" + cpf
				+ ", endereco=" + endereco + ", telefone=" + telefone
				+ ", celular=" + celular + ", email=" + email + "]";
	}

	@Override
	public boolean equals(Object objeto) 
	{
		if (this == objeto)
			return true;
		if (objeto == null)
			return false;
		if (getClass() != objeto.getClass())
			return false;
		Pessoa pessoa = (Pessoa) objeto;
		if (celular == null) 
		{
			if (pessoa.celular != null)
				return false;
		} 
		else if (!celular.equals(pessoa.celular))
			return false;
		if (cpf == null) 
		{
			if (pessoa.cpf != null)
				return false;
		} 
		else if (!cpf.equals(pessoa.cpf))
			return false;
		if (dataNascimento == null) 
		{
			if (pessoa.dataNascimento != null)
				return false;
		} 
		else if (!dataNascimento.equals(pessoa.dataNascimento))
			return false;
		if (email == null) 
		{
			if (pessoa.email != null)
				return false;
		} 
		else if (!email.equals(pessoa.email))
			return false;
		if (endereco == null) 
		{
			if (pessoa.endereco != null)
				return false;
		} 
		else if (!endereco.equals(pessoa.endereco))
			return false;
		if (id == null)
		{
			if (pessoa.id != null)
				return false;
		} 
		else if (!id.equals(pessoa.id))
			return false;
		if (nome == null)
		{
			if (pessoa.nome != null)
				return false;
		} 
		else if (!nome.equals(pessoa.nome))
			return false;
		if (rg == null)
		{
			if (pessoa.rg != null)
				return false;
		} 
		else if (!rg.equals(pessoa.rg))
			return false;
		if (telefone == null)
		{
			if (pessoa.telefone != null)
				return false;
		} 
		else if (!telefone.equals(pessoa.telefone))
			return false;
		return true;
	}	
}
