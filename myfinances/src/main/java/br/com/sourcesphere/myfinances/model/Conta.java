package br.com.sourcesphere.myfinances.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
	@OneToMany
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Categoria categoria;
	//@OneToOne @Cascade(value={CascadeType.ALL})
	//private Fornecedor fornecedor;
	@Embedded @Column(name="juros")
	private Porcentagem juros;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataVencimento;
	
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
	public List<Pagamento> getPagamentos() 
	{
		return pagamentos;
	}
	public void addPagamento(Pagamento pagamento)
	{
		this.addPagamento(pagamento, true);
	}
	public void addPagamento(Pagamento pagamento,Boolean order)
	{
		this.pagamentos.add(pagamento);
		if(order.booleanValue())
			this.ordenarPagamentos(Pagamento.getDataComparator());
	}
	public void addAllPagamentos(List<Pagamento> pagamentos) 
	{
		if(pagamentos == null) throw new NullPointerException("Pagamento não pode ser nulo");
		for(Pagamento pagamento : pagamentos)
		{
			this.addPagamento(pagamento,false);
		}
		this.ordenarPagamentos(Pagamento.getDataComparator());
	}
	public Categoria getCategoria()
	{
		return categoria;
	}
	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
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
	
	public Boolean isVencida()
	{
		DateTime hoje = new DateTime();
		if(hoje.isAfter(this.getDataVencimento()))
		{
			return true;
		}
		return false;
	}
	
	public Boolean isQuitada()
	{
		if(pagamentos.size() > 0)
		{
			Pagamento pagamento = pagamentos.get(0);
			if(pagamento.getValor() >= this.valor)
				return true;
		}
		return false;
	}
	
	private void ordenarPagamentos(Comparator<Pagamento> comparator)
	{
		Collections.sort(this.pagamentos, comparator);
	}
}
