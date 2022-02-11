package com.tsi.tom.williams.demoTest;

import com.tsi.tom.williams.demo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class menuCucumberStepsDeaf {

    private SakilaDatabaseApplication sakilaDBApp;

    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;

    @BeforeEach
    void setup() {
        languageRepository = mock(LanguageRepository.class);
        actorRepository = mock(ActorRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        filmRepository = mock(FilmRepository.class);

        sakilaDBApp = new SakilaDatabaseApplication(languageRepository, actorRepository, categoryRepository, filmRepository);
    }

    String actualResult;
    String expectedResult = "Saved";

    Language storedLanguage;
    @Given("We have a language entry to add")
    public void we_have_a_language_entry_to_add() {
        setup();
        storedLanguage = new Language("Language Test");
    }
    @When("We add the language entry")
    public void we_add_the_language_entry() {
        actualResult = sakilaDBApp.addLanguage(storedLanguage.getName());
    }
    @Then("The language should be added and we should return that the new language was saved")
    public void The_language_should_be_added() {
        Assertions.assertEquals(expectedResult, actualResult, "Save new language failed.");

        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
    }

    Actor storedActor;
    @Given("We have a new Actor to add")
    public void weHaveANewActorToAdd() {
        setup();
        storedActor = new Actor("Test", "Actor");
    }

    @When("We add the new Actor")
    public void weAddTheNewActor() {
        actualResult = sakilaDBApp.addActor(storedActor.getFirstName(), storedActor.getLastName());
    }

    @Then("The new Actor should be added and a saved conformation returned")
    public void theNewActorShouldBeAddedAndASavedConformationReturned() {
        Assertions.assertEquals(expectedResult, actualResult, "Save new Actor failed.");

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
    }

    Category storedCategory;
    @Given("We have a new Category to add")
    public void weHaveANewCategoryToAdd() {
        setup();
        storedCategory = new Category("TestCat");
    }

    @When("We add the new Category")
    public void weAddTheNewCategory() {
        actualResult = sakilaDBApp.addCategory(storedCategory.getName());
    }

    @Then("The new Category should be added and a saved conformation returned")
    public void theNewCategoryShouldBeAddedAndASavedConformationReturned() {
        Assertions.assertEquals(expectedResult, actualResult, "Save new Category failed.");

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        categoryArgumentCaptor.getValue();
    }

    Film storedFilm;
    @Given("We have a new Film to add")
    public void weHaveANewFilmToAdd() {
        setup();
        storedFilm = new Film("Test Film", "Test Description", 2006, 1, 90, "PG", "Test Special Features");
    }

    @When("We add the new Film")
    public void weAddTheNewFilm() {
        actualResult = sakilaDBApp.addFilm(storedFilm.getTitle(), storedFilm.getDescription(), storedFilm.getRelease_year(), storedFilm.getLanguageId(), storedFilm.getLength(), storedFilm.getRating(), storedFilm.getSpecialFeatures());
    }

    @Then("The new Film should be added and a saved conformation returned")
    public void theNewFilmShouldBeAddedAndASavedConformationReturned() {
        Assertions.assertEquals(expectedResult, actualResult, "Save new Film failed.");

        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
    }
}
