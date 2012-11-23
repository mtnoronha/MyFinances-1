package br.com.sourcesphere.myfinances.testes.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sourcesphere.myfinances.model.Categoria;
import br.com.sourcesphere.myfinances.testes.Testavel;

public class TesteSelectHibernate implements Testavel {

	@Override
	public void executarTeste() 
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Categoria categoria = manager.find(Categoria.class, 1L);
		System.out.println(categoria);
	}

}
