package br.com.sourcesphere.myfinances.model;

/**
 * Enum que representa níveis de prioridade entre as seguintes:
 * <p> FACULTATIVO - nível 0
 * <p> SIMPLES - nível 1
 * <p> MODERADO - nível 2
 * <p> IMPORTANTE - nível 3
 * <p> INEVITAVEL - nível 4
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
