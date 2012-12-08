package br.com.sourcesphere.myfinances.testes.hibernate;

import org.joda.time.DateTime;

import br.com.sourcesphere.myfinances.model.Endereco;
import br.com.sourcesphere.myfinances.model.Pessoa;
import br.com.sourcesphere.myfinances.testes.dao.PessoaDAO;

public class TesteInserirPessoa extends HibernateTestavel
{

	@Override
	public void executarTeste(String[] args) 
	{
		Pessoa pessoa = new Pessoa();
		pessoa.setEndereco(new Endereco("Campos Salles", "Santo André", "SP", "Brasil"));
		pessoa.setNome("Guilherme Gracia Dio");
		DateTime nascimento = new DateTime(1992, 11, 27, 0, 0);
		pessoa.setDataNascimento(nascimento);
		pessoa.setCelular("983216853");
		pessoa.setTelefone("49924790");
		pessoa.setCpf("42207727823");
		pessoa.setRg("355066634");
		pessoa.setEmail("ggrdio@gmail.com");
		new PessoaDAO().inserir(pessoa);
		System.out.println(pessoa);
	}

}
