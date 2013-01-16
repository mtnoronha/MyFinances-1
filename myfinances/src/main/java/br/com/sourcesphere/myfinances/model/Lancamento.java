package br.com.sourcesphere.myfinances.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

@Entity
public class Lancamento 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long id;
	private String descricao;
	@Enumerated(EnumType.ORDINAL)
	private TipoLancamento tipoConta;
	private Long valor;
	@OneToMany
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Categoria categoria;
	@OneToOne @Cascade(value={CascadeType.ALL})
	private Pessoa pessoa;
	private Long jurosMensal;
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
	public TipoLancamento getTipoConta() 
	{
		return tipoConta;
	}
	public void setTipoConta(TipoLancamento tipoConta) 
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
	public Pagamento getPagamento(int posicao)
	{
		if(posicao >= 0)
		{
			if(posicao < this.getPagamentos().size())
			{
				return this.getPagamentos().get(posicao);
			}
		}
		throw new ArrayIndexOutOfBoundsException("A posição do pagamento não existe na lista");
	}
	public List<Pagamento> getPagamentos() 
	{
		return pagamentos;
	}
	public void addPagamento(Pagamento pagamento,Boolean order)
	{
		if(pagamento != null)
		{
			this.pagamentos.add(pagamento);
			if(order.booleanValue())
				this.ordenarPagamentos(Pagamento.getDataComparator());
		}
	}
	public void addPagamento(Pagamento pagamento)
	{
		this.addPagamento(pagamento, true);
	}
	public void addAllPagamentos(List<Pagamento> pagamentos) 
	{
		if(pagamentos == null) throw new NullPointerException("Lista de pagamentos não pode ser nula");
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
	public void setPessoa(Pessoa pessoa) 
	{
		this.pessoa = pessoa;
	}
	public Pessoa getPessoa() 
	{
		return pessoa;
	}
	
	/**
	 * Get - Juros Mensal
	 * @return Long contendo o valor do juros aplicado mensalmente sobre o valor
	 *         <p>Formato Ex: 
	 *         <p>Para 50%, retorna 50
	 *         <p>Para 15,5%, retorna 15.5
	 */
	public Long getJurosMensal()
	{
		return jurosMensal;
	}
	
	/**
	 * Set - Juros Mensal
	 * @param jurosMensal - Valor do Juros mensal no seguinte formato:
	 * 						<p>Ex:
	 * 						<p>Para 50%, retorna 50
	 *         				<p>Para 15,5%, retorna 15.5
	 */
	public void setJurosMensal(Long jurosMensal) 
	{
		this.jurosMensal = jurosMensal;
	}
	public DateTime getDataVencimento()
	{
		return dataVencimento;
	}
	public void setDataVencimento(DateTime dataVencimento) 
	{
		this.dataVencimento = dataVencimento;
	}
	
	private void ordenarPagamentos(Comparator<Pagamento> comparator)
	{
		Collections.sort(this.pagamentos, comparator);
	}
}
