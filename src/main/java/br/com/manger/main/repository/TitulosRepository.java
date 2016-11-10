package br.com.manger.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.manger.main.model.Titulo;

public interface TitulosRepository extends JpaRepository<Titulo, Long>{

}
