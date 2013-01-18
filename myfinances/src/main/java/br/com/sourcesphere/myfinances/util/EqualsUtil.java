package br.com.sourcesphere.myfinances.util;

import java.lang.reflect.Field;
import java.util.List;


/**
 * Classe para verificar dinamicamente se objetos são iguais, por reflection
 * @author Guilherme Dio
 * @author Marco Noronha
 * @since 1.0
 */
public class EqualsUtil 
{
	
	public static boolean isEqual(Object one, Object two){
		if(ObjectUtil.nullOrEmpty(one,two)){
			return false;
		}
		
		Class<?> classOne = one.getClass();
		Class<?> classTwo = two.getClass();
		
		if(!classOne.equals(classTwo)){
			return false;
		}
		
		List<Field> oneFields = ReflectionUtil.getFields(classOne);
		List<Field> twoFields = ReflectionUtil.getFields(classTwo);
		
		if(oneFields.size() != twoFields.size()){
			return false;
		}

		boolean equal = true;
		
		for(int i = 0; i < oneFields.size(); i++){
			Field oneField = oneFields.get(i);
			Field twoField = twoFields.get(i);
			
			if(!oneField.equals(twoField)){
				return false;
			}
			
			
			Object valueOne = ReflectionUtil.getValue(one.getClass(), oneField);
			Object valueTwo = ReflectionUtil.getValue(two.getClass(), twoField);
			
			
			if(!valueOne.equals(valueTwo)){
				equal = false;
				break;
			}
		}
		
		return equal;
		
	}
	
}
