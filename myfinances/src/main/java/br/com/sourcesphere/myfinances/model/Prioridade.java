package br.com.sourcesphere.myfinances.model;

public enum Prioridade 
{
	FACULTATIVO(0),
	SIMPLES(1),
	MODERADO(2),
	IMPORTANTE(3),
	INEVITAVEL(4);
	
	private int nivel;
	
	public int nivel()
	{
		return this.nivel;
	}
	
	private Prioridade(int nivel)
	{
		this.nivel = nivel;
	}
}
