package br.com.sourcesphere.myfinances.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.vidageek.mirror.dsl.Mirror;

/**
 * Classe para recuperar os campos de uma classe através de reflection.
 * @author Guilherme Dio.
 * @autor Marco Noronha.
 *
 */
public final class ReflectionUtil 
{
	/**
	 * Recupera um campo específico.
	 * @param classe    Referência a classe que deverá ser utilizada.
	 * @param nomeCampo Nome do campo necessário.
	 * @return {@link Field}: Campo específico da classe
	 */
	public static final Field getField(Class<?> classe,String nomeCampo) 
	{
		return new Mirror().on(classe).reflect().field(nomeCampo);
	}

	/**
	 * Recupera todos os campos da classe
	 * @param classe Referência a classe que deverá ser utilizada.
	 * @return {@link List} de {@link Field}: Lista de todos os campos da classe
	 */
	public static final List<Field> getFields(Class<?> classe) 
	{
		return new Mirror().on(classe).reflectAll().fields();
	}
	
	/**
	 * Recupera valor de um campo
	 * @param clazz Referência a classe que deverá ser utilizada.
	 * @param field Referência o campo que se deseja obter o valor.
	 * @return Valor
	 */
	public static final Object getValue(Class<?> clazz,Field field)
	{
		return new Mirror().on(clazz).get().field(field);
	}
}