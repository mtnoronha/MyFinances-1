package br.com.sourcesphere.myfinances.util;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import br.com.sourcesphere.myfinances.model.Categoria;
import br.com.sourcesphere.myfinances.model.Pagamento;

public class EqualsUtilTest 
{
	@Test
	public void testIsEqualsComLongDeValoresDiferentes() 
	{
		Long lngA = new Long(1);
		Long lngB = new Long(2);
		
		EqualsUtil eUtil = EqualsUtil.getInstance(lngA);
		
		assertEquals(false, eUtil.isEquals(lngB));
	}
	
	@Test
	public void testIsEqualsComStringDeValoresDiferentes() 
	{
		String strA = new String("String A");
		String strB = new String("String B");
		
		EqualsUtil eUtil = EqualsUtil.getInstance(strA);
		//assertEquals(false, eUtil.isEquals(strB));
		
		Assert.fail("Equals para String ainda não implementado");
	}

	@Test
	public void testIsEqualsComObjetosDeValoresDiferentes() 
	{
		Categoria categoriaPrincipal = new Categoria();
		categoriaPrincipal.setId(1L);
		categoriaPrincipal.setDescricao("Categoria A");
		
		Categoria categoriaB = new Categoria();
		categoriaB.setId(1L);
		categoriaB.setDescricao("Categoria B");
		
		EqualsUtil eUtil = EqualsUtil.getInstance(categoriaPrincipal);
		
		assertEquals(false, eUtil.isEquals(categoriaB));
	}
	
	@Test
	public void testIsEqualsComObjetosDeValoresIguals() 
	{
		Categoria categoriaPrincipal = new Categoria();
		categoriaPrincipal.setId(1L);
		categoriaPrincipal.setDescricao("Categoria A");
		
		Categoria categoriaB = new Categoria();
		categoriaB.setId(1L);
		categoriaB.setDescricao("Categoria A");
		
		EqualsUtil eUtil = EqualsUtil.getInstance(categoriaPrincipal);
		
		assertEquals(true, eUtil.isEquals(categoriaB));
	}
	
	@Test
	public void testIsEqualsComObjetosDeClassesDiferentes() 
	{
		Categoria objetoA = new Categoria();
		objetoA.setId(1L);
		objetoA.setDescricao("Categoria A");
		
		Pagamento objetoB = new Pagamento();
		objetoB.setData(DateTime.now());
		
		EqualsUtil eUtil = EqualsUtil.getInstance(objetoA);
		
		assertEquals(false, eUtil.isEquals(objetoB));
	}

}
