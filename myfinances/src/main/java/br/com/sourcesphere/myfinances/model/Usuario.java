package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.joda.time.DateTime;

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
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataCadastro;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataAlteracao;
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
	public void setDataCadastro(DateTime dataCadastro) 
	{
		this.dataCadastro = dataCadastro;
	}
	public DateTime getDataCadastro() 
	{
		return dataCadastro;
	}
	public void setDataAlteracao(DateTime dataAlteracao) 
	{
		this.dataAlteracao = dataAlteracao;
	}
	public DateTime getDataAlteracao() 
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
