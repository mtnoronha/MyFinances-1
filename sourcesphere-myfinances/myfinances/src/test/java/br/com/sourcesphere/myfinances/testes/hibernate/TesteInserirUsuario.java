package br.com.sourcesphere.myfinances.testes.hibernate;

import java.util.Calendar;

import br.com.sourcesphere.myfinances.model.Usuario;
import br.com.sourcesphere.myfinances.testes.dao.PessoaDAO;
import br.com.sourcesphere.myfinances.testes.dao.UsuarioDAO;

public class TesteInserirUsuario extends HibernateTestavel
{
	@Override
	public void executarTeste(String[] args) 
	{
		Usuario usuario = new Usuario();
		usuario.setPessoa(new PessoaDAO().buscar(4L));
		usuario.setAtivo(true);
		usuario.setDataCadastro(Calendar.getInstance());
		usuario.setLogin("ggdio");
		usuario.setSenha("senha123");
		new UsuarioDAO().inserir(usuario);
		System.out.println(usuario);
	}
}
