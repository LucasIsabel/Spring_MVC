package br.com.manger.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/title")
public class TitleController {

	
	@GetMapping(value = {"","/new"})
	public String welcomeTitle(){
		return "RegisterTitle";
	}
}
