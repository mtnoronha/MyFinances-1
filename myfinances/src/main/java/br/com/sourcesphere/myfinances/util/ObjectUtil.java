package br.com.sourcesphere.myfinances.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Classe para evitar IFs espalhados nos códigos
 * @author Marco Noronha
 * @since 1.0
 */
public class ObjectUtil {

	public static boolean nullOrEmpty(Object... objects) {

		for (Object obj : objects) {
			if (obj == null) {
				return true;
			}

			if (obj instanceof String) {
				String o = (String) obj;
				if (o.equals("")) {
					return true;
				}
			}
		}

		return false;
	}
		
	public static boolean nullOrEmpty(List<?>... lists){
		for(List<?> list : lists){
			if(list == null || list.isEmpty()){
				return true;
			}
		}
		
		return false;
	}
	
	public static <T> List<T> removeRepeatedValues(List<T> list){
		List<T> novaLista = new ArrayList<T>(new HashSet<T>(list));
		return novaLista;
	}
	
	public static Boolean isLastElement(List<?> list, Object item){
		int lastIndex = list.size();
		int itemIndex = list.indexOf(item);
		
		return itemIndex == lastIndex-1 ? true : false;
	
	}

}
