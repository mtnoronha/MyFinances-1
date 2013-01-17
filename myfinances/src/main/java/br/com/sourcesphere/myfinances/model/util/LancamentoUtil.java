package br.com.sourcesphere.myfinances.model.util;

import java.util.Collections;
import java.util.Comparator;

import org.joda.time.DateTime;

import br.com.sourcesphere.myfinances.model.Lancamento;
import br.com.sourcesphere.myfinances.model.Pagamento;

/**
 * Classe no padr�o singleton que implementa utilidades para a utiliza��o da classe Lancamento
 * <p>Para obter um inst�ncia, utilize o m�todo {@link #getInstance(Lancamento)}
 * @author Guilherme Dio
 * @since 1.0
 */
public class LancamentoUtil 
{
	//Inst�ncia Singleton
	private static LancamentoUtil instance;
	
	//Lancamento a ser utilizado
	private Lancamento lancamento;
	
	private LancamentoUtil() {}
	
	/**
	 * M�todo que retorna uma instancia da classe
	 * @param conta Objeto contendo o Lancamento a ser utilizada
	 * @since 1.0
	 */
	public static LancamentoUtil getInstance(Lancamento lancamento)
	{
		if(instance == null)
			instance = new LancamentoUtil();
		instance.setLancamento(lancamento);
		return instance;
	}
	
	private void setLancamento(Lancamento lancamento) 
	{
		this.lancamento = lancamento;
	}
	
	/**
	 * Indica se o Lancamento esta vencido ou n�o
	 * @return True - para lancamento vencido
	 * 		<p>False - para lancamento dentro do prazo
	 */
	public Boolean isVencido()
	{
		DateTime hoje = new DateTime();
		if(hoje.isAfter(lancamento.getDataVencimento()))
			return true;
		return false;
	}
	
	/**
	 * Indica se o Lancamento esta quitado ou n�o
	 * @return True - para lancamento quitado
	 * 		<p>False - para lancamento n�o quitado
	 */
	public Boolean isQuitado()
	{
		if(lancamento.getPagamentos().size() > 0)
		{
			Pagamento pagamento = lancamento.getPagamento(0);
			if(pagamento.getValor() >= lancamento.getValor())
				return true;
		}
		return false;
	}
	
	/**
	 * Ordena os pagamentos efetuados a partir de um comparator
	 * @param comparator - Comparator que pode ser obtido na classe {@link PagamentoUtil}
	 */
	public void ordenarPagamentos(Comparator<Pagamento> comparator)
	{
		Collections.sort(this.lancamento.getPagamentos(), comparator);
	}
}
