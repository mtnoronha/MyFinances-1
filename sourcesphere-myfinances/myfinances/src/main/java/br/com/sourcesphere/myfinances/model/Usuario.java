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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import br.com.sourcesphere.myfinances.seguranca.Criptografia;

@Entity
@SQLDelete(sql="update Cliente set ativo = 0 where id = ?")
@Where(clause="ativo = 1")
public class Usuario
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long id;
	private String login;
	private String senha;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAlteracao;
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Pessoa pessoa;
	private Boolean ativo;
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getLogin() 
	{
		return login;
	}
	public void setLogin(String login) 
	{
		this.login = login;
	}
	public String getSenha()
	{
		return senha;
	}
	public void setSenha(String senha) 
	{
		this.senha = Criptografia.gerarHash(senha);
	}
	public void setDataCadastro(Calendar dataCadastro) 
	{
		this.dataCadastro = dataCadastro;
	}
	public Calendar getDataCadastro() 
	{
		return dataCadastro;
	}
	public void setDataAlteracao(Calendar dataAlteracao) 
	{
		this.dataAlteracao = dataAlteracao;
	}
	public Calendar getDataAlteracao() 
	{
		return dataAlteracao;
	}
	public void setPessoa(Pessoa pessoa) 
	{
		this.pessoa = pessoa;
	}
	public Pessoa getPessoa() 
	{
		return pessoa;
	}
	public Boolean isAtivo()
	{
		return ativo;
	}
	public void setAtivo(Boolean ativo)
	{
		this.ativo = ativo;
	}
}
