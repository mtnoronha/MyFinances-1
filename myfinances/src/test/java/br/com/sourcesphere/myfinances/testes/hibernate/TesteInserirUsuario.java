package br.com.sourcesphere.myfinances.testes.hibernate;

import org.joda.time.DateTime;

import br.com.sourcesphere.myfinances.model.Usuario;
import br.com.sourcesphere.myfinances.testes.dao.UsuarioDAO;

public class TesteInserirUsuario extends HibernateTestavel
{
	@Override
	public void executarTeste(String[] args) 
	{
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setDataCadastro(new DateTime());
		usuario.setLogin("ggdio");
		usuario.setSenha("senha123");
		new UsuarioDAO().inserir(usuario);
		System.out.println(usuario);
	}
}
