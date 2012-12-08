package br.com.sourcesphere.myfinances.testes.hibernate;

import br.com.sourcesphere.myfinances.model.Compromisso;
import br.com.sourcesphere.myfinances.testes.dao.CompromissoDAO;

public class TesteBuscarCompromisso extends HibernateTestavel 
{

	@Override
	public void executarTeste(String[] args) 
	{
		Compromisso compromisso = new CompromissoDAO().buscar(1L);
		System.out.println(compromisso);
	}

}
