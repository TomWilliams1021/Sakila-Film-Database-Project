package com.tsi.tom.williams.demo;

import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class SakilaDatabaseApplication {

	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmRepository filmRepository;

	private static final String save = "Saved";

	public SakilaDatabaseApplication(LanguageRepository languageRepository, ActorRepository actorRepository, CategoryRepository categoryRepository, FilmRepository filmRepository){
		this.languageRepository = languageRepository;
		this.actorRepository = actorRepository;
		this.categoryRepository = categoryRepository;
		this.filmRepository = filmRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(SakilaDatabaseApplication.class, args);
	}


	@PostMapping("/AddLanguage")
	public @ResponseBody
	String addLanguage(@RequestParam String name) {
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}

	@PostMapping("/AddActor")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return save;
	}

	@PostMapping("/AddFilm")
	public @ResponseBody
	String addFilm(@RequestParam String title, String description, int release_year, int language_id, int length, String rating, String special_features){
		Film addFilm = new Film(title, description, release_year, language_id, length, rating, special_features);
		filmRepository.save(addFilm);
		return save;
	}


	@PostMapping("/AddCategory")
	public @ResponseBody
	String addCategory(@RequestParam String name){
		Category addCategory = new Category(name);
		categoryRepository.save(addCategory);
		return save;
	}

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable<Language> getAllLanguages(){
		return languageRepository.findAll();
	}

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/AllCategorys")
	public @ResponseBody
	Iterable<Category> getAllCategorys(){
		return categoryRepository.findAll();
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("AllFilms/{id}")
	public @ResponseBody
	Optional<Film> getSpecificFilmById(@PathVariable int id){
		return filmRepository.findById(id);
	}

	@DeleteMapping("/DeleteCategory/{CategoryID}")
	public @ResponseBody String deleteCategoryByID(@PathVariable int categoryID){
		categoryRepository.deleteById(categoryID);
		return "deleted";
	}

	@PutMapping("/UpdateCategory/{CategoryID}")
	public @ResponseBody
	String updateCategory(@PathVariable int categoryID, @RequestParam String newCategoryName){
		Category updateCategory = categoryRepository.findById(categoryID).orElseThrow(() ->new ResourceNotFoundException("Review not found"));
		updateCategory.setName(newCategoryName);
		//final Category updatedCategory = categoryRepository.save(updateCategory);
		return "updated";
	}


}
