package br.com.sourcesphere.myfinances.model.util;

import java.util.Comparator;

import br.com.sourcesphere.myfinances.model.Pagamento;

/**
 * Classe no padrão singleton que implementa utilidades para a utilização da classe {@link Pagamento}
 * <p>Para obter um instância, utilize o método {@link #getInstance(Pagamento)}
 * @author Guilherme Dio
 * @since 1.0
 */
public class PagamentoUtil
{
	//Instância singleton
	private static PagamentoUtil instance;
	
	//Pagamento a ser utilizado
	private Pagamento pagamento;
	
	private PagamentoUtil() {}
	
	/**
	 * Método que retorna uma instancia da classe
	 * @param pagamento - Objeto contendo o Pagamentos a ser utilizado
	 * @since 1.0
	 */
	public static PagamentoUtil getInstance(Pagamento pagamento)
	{
		if(instance == null)
			instance = new PagamentoUtil();
		instance.setPagamento(pagamento);
		return instance;
	}
	
	private void setPagamento(Pagamento pagamento) 
	{
		this.pagamento = pagamento;
	}
	
	/**
	 * Get - Comparator de Data
	 * @return Comparator<{@link Pagamento}> para comparação pela data do pagamento
	 */
	public Comparator<Pagamento> getDataComparator()
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
