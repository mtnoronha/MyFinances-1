package br.com.sourcesphere.myfinances.testes.hibernate;

import br.com.sourcesphere.myfinances.database.DatabaseManager;
import br.com.sourcesphere.myfinances.database.PersistenceUnit;
import br.com.sourcesphere.myfinances.seguranca.Criptografia;
import br.com.sourcesphere.myfinances.seguranca.TipoAlgoritmo;
import br.com.sourcesphere.myfinances.testes.Testavel;

public abstract class HibernateTestavel implements Testavel 
{
	public HibernateTestavel()
	{
		DatabaseManager.init(PersistenceUnit.TEST);
		Criptografia.iniciar(TipoAlgoritmo.MD5);
	}
	
	@Override
	public abstract void executarTeste(String[] args);
}
