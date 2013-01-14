package br.com.sourcesphere.myfinances.dados;

public class Porcentagem 
{
	private Long valor;
	private Long porcentagem;
	
	public Porcentagem(Long valor,Long porcentagem)
	{
		this.valor = valor;
		this.porcentagem = porcentagem;
	}
	
	public void setValor(Long valor) 
	{
		this.valor = valor;
	}
	
	public void setPorcentagem(Long porcentagem) 
	{
		this.porcentagem = porcentagem;
	}
	
	public Long aplicaAcrescimo()
	{
		if(valor == null) throw new PorcentagemException("Impossível aplicar acrescimo em um valor nulo");
		return valor + ((porcentagem/100) * valor);
	}
	
	public Long aplicaDecrescimo()
	{
		if(valor == null) throw new PorcentagemException("Impossível aplicar decrescimo em um valor nulo");
		return valor - ((porcentagem/100) * valor);
	}
}
