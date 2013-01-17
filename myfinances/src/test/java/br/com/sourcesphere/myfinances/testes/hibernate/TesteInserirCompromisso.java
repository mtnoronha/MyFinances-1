package br.com.sourcesphere.myfinances.testes.hibernate;

import org.joda.time.DateTime;

import br.com.sourcesphere.myfinances.model.Compromisso;
import br.com.sourcesphere.myfinances.model.Prioridade;
import br.com.sourcesphere.myfinances.testes.dao.CompromissoDAO;

public class TesteInserirCompromisso extends HibernateTestavel
{
	@Override
	public void executarTeste(String[] args) 
	{
		Compromisso compromisso = new Compromisso();
		compromisso.addPessoa(null);
		compromisso.setData(new DateTime().plusDays(2));
		compromisso.addPessoa(null);
		compromisso.setPrioridade(Prioridade.IMPORTANTE);
		new CompromissoDAO().inserir(compromisso);
		System.out.println(compromisso);
	}
}
