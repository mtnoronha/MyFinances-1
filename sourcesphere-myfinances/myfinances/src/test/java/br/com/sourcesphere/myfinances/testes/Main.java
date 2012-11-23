package br.com.sourcesphere.myfinances.testes;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class Main 
{	
	public static Logger log = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) 
	{
		if(args.length == 0)
			sair(Priority.WARN,"Nenhum argumento informado, o programa será finalizado");
		if(args.length > 1)
			sair(Priority.WARN,"Mais do que um argumento informado, o programa será finalizado");
		String classe = args[0];
		if("".equals(classe) || classe == null)
			sair(Priority.WARN,"Argumento em branco ou nulo, o programa será finalizado");
		try 
		{
			Testavel teste = (Testavel)Class.forName(classe).newInstance();
			log.info("Iniciando o teste na classe "+teste.getClass().getName());
			teste.executarTeste();
			sair(Priority.INFO,"Fim do teste na classe "+teste.getClass().getName());
		}
		catch (InstantiationException e)
		{
			sair(Priority.ERROR,"Ocorreu um erro ao instanciar a classe argumentada");
		} 
		catch (IllegalAccessException e)
		{
			sair(Priority.ERROR,"A classe informada no argumento possuí acesso restrito");
		} 
		catch (ClassNotFoundException e) 
		{
			sair(Priority.ERROR,"A classe informada no argumento não existe");
		}
		catch(ClassCastException e)
		{
			sair(Priority.ERROR,"A classe informada não implementa a interface 'Testavel.java'");
		}
	}
	
	private static void sair(Priority priority,String msg)
	{
		log.log(priority, msg);
		System.exit(0);
	}
}
