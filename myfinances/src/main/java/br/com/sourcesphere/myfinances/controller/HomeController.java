package br.com.sourcesphere.myfinances.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController 
{
	public static final String BASE = "home/";
	public static final Logger log = Logger.getLogger(HomeController.class.getName());
	
	public HomeController() 
	{
		log.info("Servlet 'HomeServlet' iniciada");
	}
	
	@RequestMapping("")
	public String indexAction(HttpServletRequest request,String idioma)
	{
		if(idioma != null)
		{
			log.info("Trocando o idioma da sessão["+request.getSession().getId()+"] para "+idioma);
			Locale locale = new Locale(idioma);
			Config.set(request.getSession(), Config.FMT_LOCALE, locale);
			Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
		}
		log.debug("Enviando a view 'construcao.jsp' para o client-side");
		return BASE+"construcao";
	}
}
