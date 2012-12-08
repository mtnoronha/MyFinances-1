package br.com.sourcesphere.myfinances.testes.hibernate;

import br.com.sourcesphere.myfinances.model.Pessoa;
import br.com.sourcesphere.myfinances.testes.dao.PessoaDAO;

public class TesteBuscarPessoa extends HibernateTestavel {

	@Override
	public void executarTeste(String[] args) 
	{
		 Pessoa pessoa = new PessoaDAO().buscar(4L);
		 System.out.println(pessoa);
	}

}
