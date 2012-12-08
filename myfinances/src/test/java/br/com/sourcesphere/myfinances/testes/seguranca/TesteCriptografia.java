package br.com.sourcesphere.myfinances.testes.seguranca;

import org.apache.log4j.Logger;

import br.com.sourcesphere.myfinances.seguranca.Criptografia;
import br.com.sourcesphere.myfinances.seguranca.TipoAlgoritmo;
import br.com.sourcesphere.myfinances.testes.Testavel;

public class TesteCriptografia implements Testavel
{
	private static Logger log = Logger.getLogger(TesteCriptografia.class.getName());
	
	@Override
	public void executarTeste(String[] args) 
	{
		if(args.length == 2)
		{
			String algoritmo = args[0];
			try
			{
				Criptografia.iniciar(TipoAlgoritmo.valueOf(TipoAlgoritmo.class, algoritmo));
				String senha = args[1];
				Criptografia.gerarHash(senha);
			}
			catch(IllegalStateException e)
			{
				log.error("O Tipo de Algoritmo não existe ou não esta disponível para gerar o Hash");
			}
			catch(NullPointerException e)
			{
				log.error("O Tipo de Algoritmo esta nulo");
			}
		}
	}
	
}
