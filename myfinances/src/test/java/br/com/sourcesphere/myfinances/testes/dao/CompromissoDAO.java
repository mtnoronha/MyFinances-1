package br.com.sourcesphere.myfinances.testes.dao;

import br.com.sourcesphere.myfinances.database.DatabaseManager;
import br.com.sourcesphere.myfinances.model.Compromisso;

public class CompromissoDAO
{
	DatabaseManager<Compromisso> manager = new DatabaseManager<Compromisso>();

	public void inserir(Compromisso compromisso)
	{
		DatabaseManager.beginTransaction();
		DatabaseManager.persist(manager.merge(compromisso));
		DatabaseManager.endTransaction(true);
		DatabaseManager.clear();
	}
	
	public Compromisso buscar(Long id)
	{
		DatabaseManager.beginTransaction();
		Compromisso compromisso =   manager.merge(manager.find(Compromisso.class, id));
		DatabaseManager.endTransaction(false);
		DatabaseManager.clear();
		return compromisso;
	}
	
}
