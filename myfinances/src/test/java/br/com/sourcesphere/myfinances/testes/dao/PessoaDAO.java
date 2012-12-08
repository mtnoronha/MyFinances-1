package br.com.sourcesphere.myfinances.testes.dao;

import br.com.sourcesphere.myfinances.database.DatabaseManager;
import br.com.sourcesphere.myfinances.model.Pessoa;

//Classe DAO para testes
public class PessoaDAO 
{
	private DatabaseManager<Pessoa> manager = new DatabaseManager<Pessoa>();
	
	public void inserir(Pessoa pessoa)
	{
		DatabaseManager.beginTransaction();
		DatabaseManager.persist(manager.merge(pessoa));
		DatabaseManager.endTransaction(true);
		DatabaseManager.clear();
	}
	
	public Pessoa buscar(Long id)
	{
		DatabaseManager.beginTransaction();
		Pessoa pessoa =   manager.merge(manager.find(Pessoa.class, id));
		DatabaseManager.endTransaction(false);
		DatabaseManager.clear();
		return pessoa;
	}
}
