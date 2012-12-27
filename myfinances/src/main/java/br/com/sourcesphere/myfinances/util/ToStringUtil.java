package br.com.sourcesphere.myfinances.util;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ToStringUtil 
{
	private Set<String> ignorados = new HashSet<String>();
	
	private static ToStringUtil instance;
	
	private ToStringUtil()
	{}
	
	private ToStringUtil(Set<String> ignorados)
	{
		this.addAllCamposIgnorados(ignorados);
	}
	
	public static ToStringUtil getInstance()
	{
		return getInstance(new HashSet<String>());
	}
	
	public static ToStringUtil getInstance(Set<String> ignorados)
	{
		if(instance == null)
			instance = new ToStringUtil(ignorados);
		else
		{
			instance.clear();
			instance.addAllCamposIgnorados(ignorados);
		}
		return instance;
	}
	
	public void addAllCamposIgnorados(Set<String> ignorados)
	{
		for(String ignorado : ignorados)
			this.addCampoIgnorado(ignorado);
	}
	
	public void addCampoIgnorado(String ignorado)
	{
		this.ignorados.add(ignorado);
	}

	private void clear()
	{
		this.ignorados.clear();
	}
	
	@SuppressWarnings("rawtypes")
	public String toString(Object objeto)
	{
		Class clazz = objeto.getClass();
		List<Field> campos = CampoGetter.getFields(clazz);
		StringBuilder sb = new StringBuilder(clazz.getSimpleName()+":\r\n{");
		for(Field campo : campos)
		{
			if(!isIgnorado(campo))
			{
				String valor = CampoGetter.getValue(campo, objeto).toString();
				sb.append("\r\n"+campo.getName()+": "+valor);
			}
		}
		sb.append("\r\n}");
		return sb.toString();
	}
	
	private boolean isIgnorado(Field campo)
	{
		if(ignorados.contains(campo.getName()))
			return true;
		return false;
	}
}
