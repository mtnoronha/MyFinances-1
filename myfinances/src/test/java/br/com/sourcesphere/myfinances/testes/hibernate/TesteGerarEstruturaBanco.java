package br.com.sourcesphere.myfinances.testes.hibernate;

import org.apache.log4j.Priority;

import br.com.sourcesphere.myfinances.database.DatabaseManager;
import br.com.sourcesphere.myfinances.database.PersistenceUnit;
import br.com.sourcesphere.myfinances.testes.Main;

public class TesteGerarEstruturaBanco extends HibernateTestavel
{	
	@SuppressWarnings("deprecation")
	@Override
	public void executarTeste(String[] args) 
	{
		try
		{
			DatabaseManager.init(PersistenceUnit.TEST);
		}
		catch(Exception e)
		{
			Main.sair(Priority.ERROR, "Ocorreu um erro ao gerar a estrutura: "+e.getMessage());
		}
	}
}