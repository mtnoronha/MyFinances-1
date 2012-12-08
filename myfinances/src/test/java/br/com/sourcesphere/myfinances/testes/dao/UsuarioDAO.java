package br.com.sourcesphere.myfinances.testes.dao;

import br.com.sourcesphere.myfinances.database.DatabaseManager;
import br.com.sourcesphere.myfinances.model.Usuario;

public class UsuarioDAO 
{
	private DatabaseManager<Usuario> manager = new DatabaseManager<Usuario>();
	
	public void inserir(Usuario usuario)
	{
		DatabaseManager.beginTransaction();
		DatabaseManager.persist(manager.merge(usuario));
		DatabaseManager.endTransaction(true);
		DatabaseManager.clear();
	}
	
	public Usuario buscar(Long id)
	{
		DatabaseManager.beginTransaction();
		Usuario usuario =  manager.find(Usuario.class, id);
		DatabaseManager.endTransaction(false);
		DatabaseManager.clear();
		return usuario;
	}
}
