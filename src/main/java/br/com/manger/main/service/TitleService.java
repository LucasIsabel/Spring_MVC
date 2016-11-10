package br.com.manger.main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.manger.main.model.Titulo;
import br.com.manger.main.repository.TitulosRepository;

@Service
@Transactional
public class TitleService {

	@Autowired
	private TitulosRepository repository;
	
	public void saveTitulo(Titulo titulo){
		repository.save(titulo);
	}
}
