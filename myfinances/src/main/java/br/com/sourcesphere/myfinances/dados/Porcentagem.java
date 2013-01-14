package br.com.sourcesphere.myfinances.dados;

import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe que implementa cálculos de porcentagem sobre um valor
 * @author Guilherme Dio
 * @since 1.0
 */
@Embeddable
public class Porcentagem
{
	@Column
	private Long porcento;
	
	public Porcentagem() {}
	
	/**
	 * Este construtor recebe um valor por cento
	 * @see #setPorcento(Long)
	 * @since 1.0
	 */
	public Porcentagem(Long valorPorCento)
	{
		setPorcento(porcento);
	}
	
	/**
	 * Método para atribuir o valor percentual
	 * @param valorPorCento Valor por cento a ser utilizado. Exemplos:
	 *                      <p>Ex: Para 10%, informe 10.
	 *                      <p>Ex: Para 50%, informe 50.
	 *                      <p>Ex: Para 200%, informe 200.
	 */
	public void setPorcento(Long valorPorCento) 
	{
		if(porcento != null)
			this.porcento = (porcento/100);
		else
			this.porcento = 0L;
	}
	
	/**
	 * Get do percentual númerico
	 * @return Valor percentual
	 *         <p> Ex: 0.5
	 */
	public Long getPorcento() 
	{
		return porcento;
	}
	
	/**
	 * Método para retornar o percentual formatado em uma String
	 * @return Uma String contendo o valor percentual formatado
	 *         <p> Ex: 50%
	 */
	public String getPorcentoFormatado()
	{
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		percentFormat.setMinimumFractionDigits(1);
		return percentFormat.format(this.porcento);
	}
	
	/**
	 * Acrescenta devida porcentagem do valor parametrizado
	 * @param valor - Parametro contendo o valor ao qual a porcentagem deve ser aplicada.
	 * @return Um Long contendo o valor acrescido da porcentagem parametrizada.
	 */
	public Long aplicaAcrescimo(Long valor)
	{
		if(valor == null) throw new PorcentagemException("Impossível aplicar acrescimo em um valor nulo");
		return valor + calculaPorcentagem(valor);
	}
	
	/**
	 * Decrementa devida porcentagem do valor parametrizado
	 * @param valor - Parametro contendo o valor ao qual a porcentagem deve ser aplicada.
	 * @return Um Long contendo o valor decrescido da porcentagem parametrizada.
	 */
	public Long aplicaDecrescimo(Long valor)
	{
		if(valor == null) throw new PorcentagemException("Impossível aplicar decrescimo em um valor nulo");
		return valor - calculaPorcentagem(valor);
	}
	
	/**
	 * Calcula o percentual do valor
	 * @param valor - Parametro contendo o valor para o calculo.
	 * @return Um Long contendo o percentual do valor.
	 */
	private Long calculaPorcentagem(Long valor)
	{
		return porcento * valor;
	}
}
