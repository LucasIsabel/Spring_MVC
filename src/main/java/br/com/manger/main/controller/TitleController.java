package br.com.manger.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.manger.main.model.Titulo;
import br.com.manger.main.service.TitleService;

@Controller
@RequestMapping(value = "/titulo")
public class TitleController {

	@Autowired
	private TitleService service;
	
	@GetMapping(value = {"","/novo"})
	public String welcomeTitle(){
		return "RegistroTitulo";
	}
	
	@PostMapping(value = {"/cadastro"})
	public String save(Titulo title){
		
		service.saveTitulo(title);
		
		return "RegistroTitulo";
	}
}
