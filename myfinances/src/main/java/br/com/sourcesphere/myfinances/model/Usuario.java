package br.com.sourcesphere.myfinances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.joda.time.DateTime;

import br.com.sourcesphere.myfinances.seguranca.Criptografia;

@Entity
@SQLDelete(sql="update usuario set ativo = 0 where id = ?")
@Where(clause="ativo = 1")
public class Usuario extends Pessoa
{
	@Column(unique=true,nullable=false)
	private String login;
	private String senha;
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Recurso recurso;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataCadastro;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataAlteracao;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataUltimoLogin;
	private Boolean ativo;
	
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
	public Recurso getRecurso() 
	{
		return recurso;
	}
	public void setRecurso(Recurso recurso) 
	{
		this.recurso = recurso;
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
	public void setDataUltimoLogin(DateTime dataUltimoLogin)
	{
		this.dataUltimoLogin = dataUltimoLogin;
	}
	public DateTime getDataUltimoLogin() 
	{
		return dataUltimoLogin;
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
