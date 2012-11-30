package br.com.sourcesphere.myfinances.testes.hibernate;

import java.util.Calendar;

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
		Calendar nascimento = Calendar.getInstance();
		nascimento.set(Calendar.YEAR, 1992);
		nascimento.set(Calendar.MONTH, Calendar.NOVEMBER);
		nascimento.set(Calendar.DAY_OF_MONTH, 27);
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
