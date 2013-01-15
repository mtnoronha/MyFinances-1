package br.com.sourcesphere.myfinances.model.util;

import org.joda.time.DateTime;

import br.com.sourcesphere.myfinances.model.Conta;
import br.com.sourcesphere.myfinances.model.Pagamento;

/**
 * Classe no padr�o singleton que implementa utilidades para a utiliza��o da classe Conta
 * <p>Para obter um inst�ncia, utilize o m�todo {@link #getInstance(Conta)}
 * @author Guilherme Dio
 * @since 1.0
 */
public class ContaUtil 
{
	//Inst�ncia Singleton
	private static ContaUtil instance;
	
	//Conta a ser utilizada
	private Conta conta;
	
	private ContaUtil() {}
	
	/**
	 * M�todo que retorna uma instancia da classe
	 * @param conta Objeto contendo a conta a ser utilizada
	 * @since 1.0
	 */
	public static ContaUtil getInstance(Conta conta)
	{
		if(instance == null)
			instance = new ContaUtil();
		instance.setConta(conta);
		return instance;
	}
	
	private void setConta(Conta conta) 
	{
		this.conta = conta;
	}
	
	/**
	 * Indica se a conta esta vencida ou n�o
	 * @return True - para conta vencida
	 * 		<p>False - para conta dentro do prazo
	 */
	public Boolean isVencida()
	{
		DateTime hoje = new DateTime();
		if(hoje.isAfter(conta.getDataVencimento()))
			return true;
		return false;
	}
	
	/**
	 * Indica se a conta esta quitada ou n�o
	 * @return True - para conta quitada
	 * 		<p>False - para conta dentro n�o quitada
	 */
	public Boolean isQuitada()
	{
		if(conta.getPagamentos().size() > 0)
		{
			Pagamento pagamento = conta.getPagamento(0);
			if(pagamento.getValor() >= conta.getValor())
				return true;
		}
		return false;
	}
}
