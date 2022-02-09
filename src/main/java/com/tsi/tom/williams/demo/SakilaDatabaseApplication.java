package com.tsi.tom.williams.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class SakilaDatabaseApplication {

	@Autowired
	private LanguageRepository languageRepository;
	private ActorRepository actorRepository;
	private CategoryRepository categoryRepository;
	private FilmRepository filmRepository;

	public SakilaDatabaseApplication(LanguageRepository languageRepository, ActorRepository actorRepository, CategoryRepository categoryRepository, FilmRepository filmRepository){
		this.languageRepository = languageRepository;
		this.actorRepository = actorRepository;
		this.categoryRepository = categoryRepository;
		this.filmRepository = filmRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(SakilaDatabaseApplication.class, args);
	}

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable<Language> GetAllLanguages(){
		return languageRepository.findAll();
	}

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor> GetAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/AllCategorys")
	public @ResponseBody
	Iterable<Category> GetAllCategorys(){
		return categoryRepository.findAll();
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> GetAllFilms(){
		return filmRepository.findAll();
	}

	public static boolean testTest(){
		return true;
	}
}
