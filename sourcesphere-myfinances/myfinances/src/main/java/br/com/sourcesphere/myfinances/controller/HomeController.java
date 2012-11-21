package br.com.sourcesphere.myfinances.controller;

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
	public String indexAction()
	{
		log.debug("Enviando view 'index.jsp' para o client");
		return BASE+"index";
	}
}
