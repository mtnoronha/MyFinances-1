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
	private String cep;
	private String rua;
	private Integer complemento;
	private String cidade;
	@Column(length=2)
	private String estado;
	private String pais;
	
	public Endereco() {}
	
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
	public void setCep(String cep)
	{
		this.cep = cep;
	}
	public String getCep() 
	{
		return cep;
	}
	public String getRua()
	{
		return rua;
	}
	public void setRua(String rua) 
	{
		this.rua = rua;
	}
	public Integer getComplemento() 
	{
		return complemento;
	}
	public void setComplemento(Integer complemento) 
	{
		this.complemento = complemento;
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
}
