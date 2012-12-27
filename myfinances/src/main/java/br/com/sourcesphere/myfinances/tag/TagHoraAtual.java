package br.com.sourcesphere.myfinances.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public final class TagHoraAtual extends SimpleTagSupport 
{
	private static final Logger log = Logger.getLogger(TagHoraAtual.class.getName());
	
	@Override
	public void doTag() throws JspException, IOException 
	{
		final JspWriter writer = super.getJspContext().getOut();
		try
		{
			writer.print(new DateTime().toString("hh:mm"));
		}
		catch(IOException e)
		{
			log.error("Erro ao imprimir a hora atual na Tag: TagHoraAtual",e);
		}
	}
}
