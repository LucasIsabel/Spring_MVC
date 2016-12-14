package br.com.manger.main.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.manger.main.constants.Constants;
import br.com.manger.main.model.StatusTitulo;
import br.com.manger.main.model.Titulo;
import br.com.manger.main.service.TitleService;

@Controller
@RequestMapping(value = "/titulo")
public class TitleController {
	
	@Autowired
	private TitleService service;
	
	@GetMapping
	public ModelAndView searchTitles(){
		ModelAndView mv = new ModelAndView(Constants.PAGE_PESQUISA_TITULO);
		mv.addObject("listTitles",service.getAll());
		return mv;
	}
	
	@GetMapping(value = {"/novo"})
	public ModelAndView welcomeTitle(){
		ModelAndView mv = new ModelAndView(Constants.PAGE_REGISTRO_TITULO);
		mv.addObject(new Titulo());
		return mv;
	}
	
	@PostMapping(value = {"/cadastro"})
	public String save(@Validated Titulo title, Errors errors, RedirectAttributes attributes){
		if(errors.hasErrors()){
			return Constants.PAGE_REGISTRO_TITULO;
		}
		try{
			service.saveTitulo(title);
			attributes.addFlashAttribute("mensagem", "Titulo cadastrado com sucesso (" + title.getDescricao() + ")");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/titulo/novo";
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editTitle(@PathVariable("codigo") Titulo titulo){
		ModelAndView mv = new ModelAndView(Constants.PAGE_REGISTRO_TITULO);
		mv.addObject(titulo);
		return mv;
	}
	
	@DeleteMapping(value = "/{codigo}")
	public String deleteTitle(@PathVariable("codigo") Long codigo, RedirectAttributes attributs){
		Titulo titulo = service.findOne(codigo);
			if(titulo != null){
				service.deleteTitle(codigo);
				attributs.addFlashAttribute("mensagem", "Titulo ( " + titulo.getDescricao() + " ) removido com sucesso");
			}
		return "redirect:/titulo";
	}
	
	@ModelAttribute("statusTitutlo")
	public List<StatusTitulo> getStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}
