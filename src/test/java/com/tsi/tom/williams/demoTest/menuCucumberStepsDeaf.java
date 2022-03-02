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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

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

    List<Category> categoryList = new ArrayList<>();
    @Given("There are categorys available")
    public void thereAreCategorysAvailable() {
        setup();
        Category cat1 = new Category("TestCat1");
        Category cat2 = new Category("TestCat2");
        categoryList.add(cat1);
        categoryList.add(cat2);
    }

    @When("The categorys are requested")
    public void theCategorysAreRequested() {
        when(sakilaDBApp.GetAllCategorys()).thenReturn(categoryList);
    }

    @Then("All available categorys should be returned")
    public void allAvailableCategorysShouldBeReturned() {
        Assertions.assertEquals(categoryList, sakilaDBApp.GetAllCategorys(), "Category data was not retreived from Category database table.");
    }

    List<Film> filmList = new ArrayList<>();
    @Given("There are films available")
    public void thereAreFilmsAvailable() {
        setup();
        Film film1 = new Film("Test Film 1", "Test Description 1", 2006, 1, 90, "PG", "Test Special Features");
        Film film2 = new Film("Test Film 2", "Test Description 2", 2006, 1, 90, "PG", "Test Special Features");
        filmList.add(film1);
        filmList.add(film2);
    }

    @When("The films are requested")
    public void theFilmsAreRequested() {
        when(sakilaDBApp.GetAllFilms()).thenReturn(filmList);
    }

    @Then("All available films should be returned")
    public void allAvailableFilmsShouldBeReturned() {
        Assertions.assertEquals(filmList, sakilaDBApp.GetAllFilms(), "Film data was not retreived from Film database table.");
    }

    List<Actor> actorList = new ArrayList<>();
    @Given("There are actors available")
    public void thereAreActorsAvailable() {
        setup();
        Actor actor1 = new Actor("Test", "Actor1");
        Actor actor2 = new Actor("Test", "Actor2");
        actorList.add(actor1);
        actorList.add(actor2);
    }

    @When("The actors are requested")
    public void theActorsAreRequested() {
        when(sakilaDBApp.GetAllActors()).thenReturn(actorList);
    }

    @Then("All available actors should be returned")
    public void allAvailableActorsShouldBeReturned() {
        Assertions.assertEquals(actorList, sakilaDBApp.GetAllActors(), "Actor data was not retreived from Actor database table.");
    }

    List<Language> languageList = new ArrayList<>();
    @Given("There are languages available")
    public void thereAreLanguagesAvailable() {
        setup();
        Language lang1 = new Language("TestL1");
        Language lang2 = new Language("TestL2");
        languageList.add(lang1);
        languageList.add(lang2);
    }

    @When("The languages are requested")
    public void theLanguagesAreRequested() {
        when(sakilaDBApp.GetAllLanguages()).thenReturn(languageList);
    }

    @Then("All available languages should be returned")
    public void allAvailableLanguagesShouldBeReturned() {
        Assertions.assertEquals(languageList, sakilaDBApp.GetAllLanguages(), "Languages data was not retreived from Language database table.");
    }

    Film storedFilm1;
    @Given("There are films available to select from")
    public void thereAreFilmsAvailableToSelectFrom() {
        setup();
        storedFilm1 = new Film("Test Film 1", "Test Description 1", 2006, 1, 90, "PG", "Test Special Features");
    }

    @When("The user requests a specific film")
    public void theUserRequestsASpecificFilm() {
        when(sakilaDBApp.GetSpecificFilmById(0)).thenReturn(Optional.of(storedFilm1));
    }

    @Then("The specified film will be returned")
    public void theSpecifiedFilmWillBeReturned() {
        Assertions.assertEquals(Optional.of(storedFilm1), sakilaDBApp.GetSpecificFilmById(0), "Film specified by id was not retrieved from the Film database.");
    }

    int reviewID;
    String actual;
    String expected = "deleted";
    @Given("There are categorys to select from")
    public void thereAreCategorysToSelectFrom() {
        setup();
        reviewID = 1;
    }

    @When("A category is selected for deletion")
    public void aCategoryIsSelectedForDeletion() {
        actual = sakilaDBApp.deleteCategoryByID(reviewID);
    }

    @Then("The category should be deleted")
    public void theCategoryShouldBeDeleted() {
        expected = "deleted";
        Assertions.assertEquals(expected, actual, "The specified category was not successfully deleted.");

        ArgumentCaptor<Integer> categoryArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(categoryRepository).deleteById(categoryArgumentCaptor.capture());
        categoryArgumentCaptor.getValue();
    }
}
