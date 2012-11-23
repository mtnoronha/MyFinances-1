package br.com.sourcesphere.myfinances.testes.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sourcesphere.myfinances.model.Categoria;
import br.com.sourcesphere.myfinances.testes.Testavel;

public class TesteGerarEstruturaHibernate implements Testavel 
{

	@Override
	public void executarTeste() 
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Categoria categoria = new Categoria();
		categoria.setDescricao("Corrente");
		manager.persist(categoria);
		//manager.getTransaction().commit();
		//manager.close();
		//factory.close();
	}

}
