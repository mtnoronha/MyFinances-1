package br.com.sourcesphere.myfinances.model;

/**
 * Enum que representa n�veis de prioridade entre as seguintes:
 * <p> FACULTATIVO - n�vel 0
 * <p> SIMPLES - n�vel 1
 * <p> MODERADO - n�vel 2
 * <p> IMPORTANTE - n�vel 3
 * <p> INEVITAVEL - n�vel 4
 * @author Guilherme Dio
 * @since 1.0
 */
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
