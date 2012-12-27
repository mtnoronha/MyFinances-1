package br.com.sourcesphere.myfinances.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/erro/")
public class ErrorController
{
	private static final Logger log = Logger.getLogger(ErrorController.class.getName());
	
	public ErrorController() 
	{
		log.info("Controller: 'ErrorController' iniciado");
	}
	
	@RequestMapping("exception")
	public String exceptionAction()
	{
		//Implementar
		return null;
	}
	
	@RequestMapping("404")
	public String pageNotFoundAction()
	{
		//Implementar
		return null;
	}
}
