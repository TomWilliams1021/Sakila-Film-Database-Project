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

	public SakilaDatabaseApplication(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(SakilaDatabaseApplication.class, args);
	}

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable<Language> GetAllLanguages(){
		return languageRepository.findAll();
	}

	public static boolean testTest(){
		return true;
	}
}
