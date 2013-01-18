package br.com.sourcesphere.myfinances.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.vidageek.mirror.dsl.Mirror;

/**
 * Classe para recuperar os campos de uma classe atrav�s de reflection.
 * @author Guilherme Dio.
 * @autor Marco Noronha.
 *
 */
public final class ReflectionUtil 
{
	/**
	 * Recupera um campo espec�fico.
	 * @param classe    Refer�ncia a classe que dever� ser utilizada.
	 * @param nomeCampo Nome do campo necess�rio.
	 * @return {@link Field}: Campo espec�fico da classe
	 */
	public static final Field getField(Class<?> classe,String nomeCampo) 
	{
		return new Mirror().on(classe).reflect().field(nomeCampo);
	}

	/**
	 * Recupera todos os campos da classe
	 * @param classe Refer�ncia a classe que dever� ser utilizada.
	 * @return {@link List} de {@link Field}: Lista de todos os campos da classe
	 */
	public static final List<Field> getFields(Class<?> classe) 
	{
		return new Mirror().on(classe).reflectAll().fields();
	}
	
	/**
	 * Recupera valor de um campo
	 * @param clazz Refer�ncia a classe que dever� ser utilizada.
	 * @param field Refer�ncia o campo que se deseja obter o valor.
	 * @return Valor
	 */
	public static final Object getValue(Class<?> clazz,Field field)
	{
		return new Mirror().on(clazz).get().field(field);
	}
}