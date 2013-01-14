package br.com.sourcesphere.myfinances.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import br.com.sourcesphere.myfinances.dados.Porcentagem;

@Entity
public class Conta 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long id;
	private String descricao;
	@Enumerated(EnumType.ORDINAL)
	private TipoConta tipoConta;
	private Long valor;
	@OneToMany(mappedBy = "conta", targetEntity = Long.class, fetch = FetchType.LAZY)
	@Cascade(value={CascadeType.ALL})
	private List<Long> valoresPagos = new ArrayList<Long>();
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Categoria categoria;
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Fornecedor fornecedor;
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Porcentagem juros;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataVencimento;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataPagamento;
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getDescricao() 
	{
		return descricao;
	}
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	public TipoConta getTipoConta() 
	{
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta)
	{
		this.tipoConta = tipoConta;
	}
	public Long getValor() 
	{
		return valor;
	}
	public void setValor(Long valor) 
	{
		this.valor = valor;
	}
	public List<Long> getValoresPagos()
	{
		return valoresPagos;
	}
	public void setValoresPagos(List<Long> valoresPagos) 
	{
		this.valoresPagos = valoresPagos;
	}
	public Categoria getCategoria()
	{
		return categoria;
	}
	public void setCategoria(Categoria categoria) 
	{
		this.categoria = categoria;
	}
	public Fornecedor getFornecedor() 
	{
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor)
	{
		this.fornecedor = fornecedor;
	}
	public Porcentagem getJuros()
	{
		return juros;
	}
	public void setJuros(Porcentagem juros) 
	{
		this.juros = juros;
	}
	public DateTime getDataVencimento() 
	{
		return dataVencimento;
	}
	public void setDataVencimento(DateTime dataVencimento) 
	{
		this.dataVencimento = dataVencimento;
	}
	public DateTime getDataPagamento() 
	{
		return dataPagamento;
	}
	public void setDataPagamento(DateTime dataPagamento)
	{
		this.dataPagamento = dataPagamento;
	}
	
}
