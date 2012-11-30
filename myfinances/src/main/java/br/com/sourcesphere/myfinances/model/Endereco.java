package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class Endereco 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(nullable=false)
	private Long id;
	private String rua;
	private String cidade;
	@Column(length=2)
	private String estado;
	private String pais;
	
	public Endereco() 
	{}
	
	public Endereco(String rua, String cidade, String estado,String pais) 
	{
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getRua()
	{
		return rua;
	}
	public void setRua(String rua) 
	{
		this.rua = rua;
	}
	public String getCidade()
	{
		return cidade;
	}
	public void setCidade(String cidade) 
	{
		this.cidade = cidade;
	}
	public String getEstado() 
	{
		return estado;
	}
	public void setEstado(String estado) 
	{
		this.estado = estado;
	}
	public String getPais()
	{
		return pais;
	}
	public void setPais(String pais) 
	{
		this.pais = pais;
	}

	@Override
	public String toString()
	{
		return "Endereco [id=" + id + ", rua=" + rua + ", cidade=" + cidade
				+ ", estado=" + estado + ", pais=" + pais + "]";
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
		Endereco endereco = (Endereco) objeto;
		if (cidade == null) 
		{
			if (endereco.cidade != null)
				return false;
		} 
		else if (!cidade.equals(endereco.cidade))
			return false;
		if (estado == null) 
		{
			if (endereco.estado != null)
				return false;
		} 
		else if (!estado.equals(endereco.estado))
			return false;
		if (id == null) 
		{
			if (endereco.id != null)
				return false;
		} 
		else if (!id.equals(endereco.id))
			return false;
		if (pais == null) 
		{
			if (endereco.pais != null)
				return false;
		} 
		else if (!pais.equals(endereco.pais))
			return false;
		if (rua == null) 
		{
			if (endereco.rua != null)
				return false;
		} 
		else if (!rua.equals(endereco.rua))
			return false;
		return true;
	}
	
}
