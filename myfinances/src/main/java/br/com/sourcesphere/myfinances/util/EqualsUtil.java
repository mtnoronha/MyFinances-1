package br.com.sourcesphere.myfinances.util;

import java.lang.reflect.Field;
import java.util.List;


/**
 * Classe para verificar dinamicamente se objetos são iguais, por reflection
 * @author Guilherme Dio
 * @since 1.0
 */
public class EqualsUtil 
{
	private static EqualsUtil instance;
	
	private Object objeto;
	
	private EqualsUtil() {}
	
	public static EqualsUtil getInstance(Object objetoPrincipal)
	{
		if(instance == null)
			instance = new EqualsUtil();
		instance.setObjeto(objetoPrincipal);
		return instance;
	}
	
	private void setObjeto(Object objeto)
	{
		this.objeto = objeto;
	}
	
	//Sendo implementado
	public Boolean isEquals(Object outroObjeto)
	{
		Class<?> clazzObjetoPrincipal = this.objeto.getClass();
		Class<?> clazzOutroObjeto = outroObjeto.getClass();
		if(clazzObjetoPrincipal.equals(clazzOutroObjeto))
		{
			List<Field> camposObjetoPrincipal = CampoGetter.getFields(clazzObjetoPrincipal);
			List<Field> camposOutroObjeto = CampoGetter.getFields(clazzOutroObjeto);
			for(Field campoObjetoPrincipal : camposObjetoPrincipal)
			{
				for(Field campoOutroObjeto : camposOutroObjeto)
				{
					if(campoObjetoPrincipal.equals(campoOutroObjeto))
					{
						if(campoObjetoPrincipal.getType().isPrimitive())
						{
							//Checar primitivo
						}
						else
						{
							Object valorObjetoPrincipal = CampoGetter.getValue(campoObjetoPrincipal, this.objeto);
							Object valorOutroObjeto = CampoGetter.getValue(campoOutroObjeto, outroObjeto);
							if(!valorObjetoPrincipal.equals(valorOutroObjeto))
								return false;
						}
						break;
					}
				}
			}
			
		}
		return true;
	}
}
