package br.com.sourcesphere.myfinances.testes.hibernate;

import br.com.sourcesphere.myfinances.model.Endereco;
import br.com.sourcesphere.myfinances.model.Pessoa;
import br.com.sourcesphere.myfinances.model.PessoaFisica;
import br.com.sourcesphere.myfinances.testes.dao.PessoaDAO;

public class TesteInserirPessoa extends HibernateTestavel
{

	@Override
	public void executarTeste(String[] args) 
	{
		Pessoa pessoa = new PessoaFisica();
		pessoa.setEndereco(new Endereco("Campos Salles", "Santo André", "SP", "Brasil"));
		pessoa.setNome("Guilherme Gracia Dio");
		pessoa.setCelular("983216853");
		pessoa.setTelefone("49924790");
		pessoa.setEmail("ggrdio@gmail.com");
		new PessoaDAO().inserir(pessoa);
		System.out.println(pessoa);
	}

}
