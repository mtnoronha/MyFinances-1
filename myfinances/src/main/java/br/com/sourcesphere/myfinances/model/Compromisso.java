package br.com.sourcesphere.myfinances.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Classe que representa a entidade Compromisso
 * @author Guilherme Dio
 * @since 1.0
 */
@Entity
public final class Compromisso
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(nullable=false)
	private Long id;
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Usuario responsavel;
	@OneToMany
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime data;
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Endereco local;
	@Enumerated(EnumType.ORDINAL)
	private Prioridade prioridade;
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Usuario getResponsavel() 
	{
		return responsavel;
	}
	public void setResponsavel(Usuario responsavel)
	{
		this.responsavel = responsavel;
	}
	
	public Pessoa getPessoa(Integer posicao)
	{
		if(posicao >= 0)
		{
			if(posicao < this.getPessoas().size())
			{
				return this.getPessoas().get(posicao);
			}
		}
		throw new ArrayIndexOutOfBoundsException("A posição da pessoa não existe na lista");
	}
	public List<Pessoa> getPessoas()
	{
		return this.pessoas;
	}
	public void addPessoa(Pessoa pessoa)
	{
		if(pessoa != null)
		{
			this.pessoas.add(pessoa);
		}
	}
	public void addAllPessoas(Set<Pessoa> pessoas) 
	{
		if(pessoas == null) throw new NullPointerException("Lista de pessoas não pode ser nula");
		for(Pessoa pessoa : pessoas)
		{
			this.addPessoa(pessoa);
		}
	}
	
	public DateTime getData() 
	{
		return data;
	}
	public void setData(DateTime data) 
	{
		this.data = data;
	}
	public Endereco getLocal() 
	{
		return local;
	}
	public void setLocal(Endereco local)
	{
		this.local = local;
	}
	public Prioridade getPrioridade() 
	{
		return prioridade;
	}
	public void setPrioridade(Prioridade prioridade) 
	{
		this.prioridade = prioridade;
	}
}
