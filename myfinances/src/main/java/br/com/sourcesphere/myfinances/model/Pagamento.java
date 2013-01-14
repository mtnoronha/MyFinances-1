package br.com.sourcesphere.myfinances.model;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class Pagamento 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long id;
	private Long valor;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime data;
	private String observacao;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Long getValor() 
	{
		return valor;
	}
	public void setValor(Long valor) 
	{
		this.valor = valor;
	}
	public DateTime getData() 
	{
		return data;
	}
	public void setData(DateTime data) 
	{
		this.data = data;
	}
	public String getObservacao() 
	{
		return observacao;
	}
	public void setObservacao(String observacao) 
	{
		this.observacao = observacao;
	}
	
	public static Comparator<Pagamento> getDataComparator()
	{
		return new Comparator<Pagamento>() 
		{
			@Override
			public int compare(Pagamento pagamentoA, Pagamento pagamentoB) 
			{
				return pagamentoA.getData().compareTo(pagamentoB.getData());
			}
		};
	}
}
